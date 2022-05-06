var etiquettesTab = new Array();

$(document).ready(function(){
	
	
	$('#rechercheinput').keyup( function() {
		var recherche = $(this).val().toUpperCase();
		$.each($(".ligneRecherche"), function(){
			var rechercheOk = false;
			$.each($(this).find(".recherche"), function (){
				var valeurCourante = $(this).text().toUpperCase();
				if (valeurCourante.indexOf(recherche) != -1)
					rechercheOk = true;
			});
			if (rechercheOk)
				$(this).show();
			else
				$(this).hide();	
		});	
	});
	
	
	$("#meeting-time1").change(function(){
		
		var dateCompare1 = document.getElementById("meeting-time1");
		var dateCompare2 = document.getElementById("meeting-time2");
		var toConcat = ":00Z"
		var date1Comparable = dateCompare1.value.concat(toConcat);
		var date2Comparable = dateCompare2.value.concat(toConcat);
		$.each($(".ligneRecherche"), function()
		{
			var rechercheOk = false;
			$.each($(this).find(".dateRecherche"), function ()
			{
				var valeurCouranteDate = $(this).text();
				String(valeurCouranteDate);
				valeurCouranteDate = valeurCouranteDate.concat("Z");
				valeurCouranteDate = valeurCouranteDate.replace(" ", "T");
				valeurCouranteDate = valeurCouranteDate.replace(".0","");
				length1 = date1Comparable.length;
				length2 = date2Comparable.length;
				
				if ((length1 === 20) && (length2 === 20))
				{
					let borneDebut = new Date (date1Comparable);
					let borneFin = new Date (date2Comparable);
					let dateABorne = new Date (valeurCouranteDate);
					if (borneDebut <= dateABorne && borneFin >= dateABorne)
						rechercheOk = true;
				}
			});	
					if (rechercheOk)
						$(this).show();
					else
						$(this).hide();
		});	
	});
	
	
$("#meeting-time2").change(function(){
		
		var dateCompare1 = document.getElementById("meeting-time1");
		var dateCompare2 = document.getElementById("meeting-time2");
		var toConcat = ":00Z"
		var date1Comparable = dateCompare1.value.concat(toConcat);
		var date2Comparable = dateCompare2.value.concat(toConcat);
		
		$.each($(".ligneRecherche"), function()
		{
			var rechercheOk = false;
			$.each($(this).find(".dateRecherche"), function ()
			{
				var valeurCouranteDate = $(this).text();
				String(valeurCouranteDate);
				valeurCouranteDate = valeurCouranteDate.concat("Z");
				valeurCouranteDate = valeurCouranteDate.replace(" ", "T");
				valeurCouranteDate = valeurCouranteDate.replace(".0","");
				length1 = date1Comparable.length;
				length2 = date2Comparable.length;
				
				if ((length1 === 20) && (length2 === 20))
				{
					let borneDebut = new Date (date1Comparable);
					let borneFin = new Date (date2Comparable);
					let dateABorne = new Date (valeurCouranteDate);
					if (borneDebut <= dateABorne && borneFin >= dateABorne)
						rechercheOk = true;	
				}
			});	
					if (rechercheOk)
						$(this).show();
					else
						$(this).hide();
		});	
	});
		$('#refresh').on('click', function() {
		    location.reload();
		});
});

function checkboxUpdate(tacheId) {

    var tachejson = {
            tache : tacheId
    }
     $.ajax({
            type: "POST",
            url: "/changeEtat",
            data: tachejson,
        });
}

function checkboxUpdate2(tache,etiquette){
	
	check = document.getElementById(etiquette);

	if (check.checked){
		if(!(etiquettesTab.includes(etiquette)))
			etiquettesTab.push(etiquette);
		
	}
	else {
		if((etiquettesTab.includes(etiquette))){
			var cpt = etiquettesTab.indexOf(etiquette);
			console.log(cpt);
			etiquettesTab.splice(cpt,1);
		}
	}
	console.log(etiquettesTab);
	
}

function creationEtiquette(tacheId){
	console.log(tacheId);
	 var tachejson = {
	            tache : tacheId
	    }
	     $.ajax({
	            type: "POST",
	            url: "/editEtiquette",
	            data: tachejson,
	        }); 
}






















