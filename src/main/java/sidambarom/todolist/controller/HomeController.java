package sidambarom.todolist.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sidambarom.todolist.details.MyUserDetails;
import sidambarom.todolist.entity.Tache;
import sidambarom.todolist.entity.Users;
import sidambarom.todolist.repository.TacheRepository;
import sidambarom.todolist.repository.UsersRepository;


/**
 * Date : Mai 05-2022
 * Classe qui permet de gérer les différentes routes de l'application.
 * Il s'agit du controlleur.
 * @author Thomas Sidambarom
 * @version 1.0
 *
 */
@Controller
public class HomeController {

	/**
	 * Interface vers la table "Users" en bd
	 */
    @Autowired
    private UsersRepository userRepo;
    
    /**
	 * Interface vers la table "Tache" en bd
	 */
    @Autowired
    private TacheRepository tacheRepo;
    
    /**
     * Route de base, vers la page d'accueil
     */
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    
    /**
     * Route d'enregistrement d'utilisateur, vers la création d'un utilisateur
     * @param model : interface qui permet de passer des variable à la vue
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "signup_form";
    }
    
    /**
     * Route qui permet d'enregister l'utilisateur, vers la création d'un utilisateur
     * @param user : permet de récupérer le user créé au niveau de la vue
     */
    @PostMapping("/process_register")
    public String processRegister(Users user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getMdp());
        user.setMdp(encodedPassword);
        userRepo.save(user);
        return "register_success";
    }
    
    /**
     * Route de la visualisation des tâches du user
     * @param model : interface qui permet de passer des variable à la vue
     */
    @GetMapping("/users")
    public String listTache(Model model) {
    	MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    	
    	List<Tache> listTaches = userRepo.findById(userDetails.getUserId()).get().getTaches();
    	model.addAttribute("listTaches", listTaches);
        return "users";
    }
    
    /**
     * Route qui permet de rediriger vers la page de création de tâche
     */
    @GetMapping("/ajouttache")
    public String ajouttache() {
        return "ajouter tache";
    }
    
    /**
     * Route pour appliquer la modification d'etat d'une tâche (appel ajax)
     * @param tache : id de la tache 
     * @param session : récupère la session de l'utilisateur
     */
    @RequestMapping("/changeEtat")
    @ResponseBody
    public void YourActionName(@RequestParam("tache") int tache, HttpSession session ){
      Tache t = tacheRepo.getById(tache);
      if(t.getEtat() == true) {
    	  t.setEtat(false);
      }
      else 
    	  t.setEtat(true);
      tacheRepo.save(t);
    } 
    
    /**
     * Route qui permet de rediriger l'utilisateur vers la crétion de tâche depuis un bouton sur la vue
     * @param model : interface qui permet de passer des variable à la vue
     */
    @GetMapping("/create_task")
    public String showTaskForm(Model model) {
    	List<String> etiquettes = Arrays.asList("Urgent", "Personnel", "Travail");
    	model.addAttribute("etiquettes", etiquettes);
        model.addAttribute("tache", new Tache());
        return "task_form";
    }
    
    /**
     * Route qui permet la sauvegarde en BD de la nouvelle tâche créé
     * @param tache : entity tache
     */
    @PostMapping("/process_create_task")
    public String processCreateTask(Tache tache) {
    	MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    	tache.setUser(userRepo.findById(userDetails.getUserId()).get());
        tache.setEtat(false);
        LocalDateTime now = LocalDateTime.now();
        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());;
        tache.setDate(date);
        tacheRepo.save(tache);
        return "create_task_sucess";
    }
    
 /*   @RequestMapping("/editEtiquette")
    @ResponseBody
    public void YourActionName2(@RequestParam("tache") int tache, HttpSession session ){
    	System.out.println("TACHE :" + tache);
    	//Tache t = tacheRepo.getById(tache);
      

    	//System.out.println(t.getEtat());

    } */
    
   
}