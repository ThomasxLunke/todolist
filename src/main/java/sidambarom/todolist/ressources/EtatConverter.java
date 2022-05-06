package sidambarom.todolist.ressources;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Date : Mai 05-2022
 * Classe qui permet de convertir un enum (ici l'état d'une tâche) en String/enum
 * @author Thomas Sidambarom
 * @version 1.0
 *
 */
@Converter (autoApply = true)
public class EtatConverter implements AttributeConverter<EtatEnum, String> {

	@Override
	public String convertToDatabaseColumn(EtatEnum attribute) {
		if (attribute == null)
			return null;
		switch (attribute) {
		case Termine:
			return "Termine";
		case PasTermine:
			return "PasTermine";	
		}
		return null;
	}

	@Override
	public EtatEnum convertToEntityAttribute(String dbData) {
		if (dbData == null)
			return null;
		switch (dbData){
		case "Termine":
			return EtatEnum.Termine;
		case "PasTermine":
			return EtatEnum.PasTermine;
		}
		return null;
	}
	
}
