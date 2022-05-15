
function chargerObjetBebe(){
	
	var request = new XMLHttpRequest();
	
	request.onreadystatechange = function(){
		if (request.readyState == 4 && request.status == 200){
			var container = document.getElementById("ObjetBebeContainer")
			var contenuReponse = JSON.parse(request.responseText);
			for (i = 0; i < contenuReponse.length; i++) {
				
				afficherObjetBebe(container, contenuReponse[i]);
		}
	}
}
	request.open("GET", "http://localhost:8080/BudgetBB/budgetBB/objets", true);
	request.send();
}

function chargerType(){
	console.log("coucou");
	var request = new XMLHttpRequest();
	
	request.onreadystatechange = function(){
		if (request.readyState == 4 && request.status == 200){
			var container = document.getElementById("typeSelect");

			var contenuReponse = JSON.parse(request.responseText);
			for (i = 0; i < contenuReponse.length; i++) {
				
				remplirListeType(container, contenuReponse[i]);
		}
			
	}
}
	request.open("GET", "http://localhost:8080/BudgetBB/budgetBB/types", true);
	request.send();
}


function remplirListeType(container, type){
	var divOption = document.createElement('option');
	divOption.value = type.nom;
	divOption.innerText = type.nom;
	container.appendChild(divOption);
}


function afficherObjetBebe(container, objet) {
	var divObjet = document.createElement("div");
	var pNomObjet = document.createElement("input");
	var pValeurObjet = document.createElement("input");
	var pType = document.createElement("input");
	var pDateCreation = document.createElement("p");
	var pDateModification = document.createElement("p");
	pNomObjet.setAttribute("id", "nom_objet" + objet.id);
	pNomObjet.value = objet.nom;
	pValeurObjet.setAttribute("id", "valeur" + objet.id);
	
	pValeurObjet.value = Number.parseFloat(objet.valeur);
	pDateCreation.innerText =  objet.dateCreation.dayOfMonth+ " " + objet.dateCreation.month + " " + objet.dateCreation.year ;
	pDateModification.innerText = objet.dateModification.dayOfMonth + " " + objet.dateModification.month + " " + objet.dateModification.year;
	
	
	
	// J'ajoute la balise "p" du nom a l'interieur du div cree precedemment
	divObjet.appendChild(pNomObjet);
	if(objet.type.nom != "undefined"){
		pType.setAttribute("id", "type" + objet.id);
		pType.value = objet.type.nom;
		divObjet.appendChild(pType);
	}
	
	divObjet.appendChild(pValeurObjet);
	divObjet.appendChild(pDateCreation);
	divObjet.appendChild(pDateModification);
	
	var boutonModifier = document.createElement("input");
	boutonModifier.type = "button";
	boutonModifier.value = "Modifier";
	boutonModifier.setAttribute("onclick", "modifierObjetBebe("+objet.id+"); window.location.reload();");
	
	divObjet.appendChild(boutonModifier);
	
	// Je cree un bouton que j'utiliserai pour la suppression
	var boutonSupprimer = document.createElement("input");
	boutonSupprimer.type = "button";
	boutonSupprimer.value = "Supprimer";
	// La fonction supprimerContact sera appelee avec, en parametre, l'id du client concerne
	boutonSupprimer.setAttribute("onclick", "supprimerObjetBebe("+objet.id+"); window.location.reload();");
	
	divObjet.appendChild(boutonSupprimer);
	
	// J'ajoute cette balise div au container
	container.appendChild(divObjet);
}

function ajouterObjetBebe() {

	var request = new XMLHttpRequest();
	

	request.onreadystatechange = function() {

		if (request.readyState == 4 && request.status == 201) {

			chargerObjetBebe();
		}
	};
	
	/*
	 * Configuration puis envoi de la requete HTTP
	 */
	var inputNom = document.getElementById("nom_objet");
	var type = document.getElementById("typeSelect").options[document.getElementById("typeSelect").selectedIndex].text;
	var valeur = document.getElementById("valeur")
	if(type){
		var params = "nom=" + inputNom.value + "&type=" + type.value + "&valeur=" +valeur.value;
	}else{
		var params = "nom=" + inputNom.value + "&valeur=" +valeur.value;
	}
	
	
	request.open("POST", "http://localhost:8080/BudgetBB/budgetBB/objets", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send(params);
}

function supprimerObjetBebe(id){
	var request = new XMLHttpRequest();
	

	request.onreadystatechange = function() {

		if (request.readyState == 4 && request.status == 200) {

			chargerObjetBebe();
		}
	};
	request.open("DELETE", "http://localhost:8080/BudgetBB/budgetBB/objets/" + id , true);
	request.send();

	}


function modifierObjetBebe(id) {

	var request = new XMLHttpRequest();
	

	request.onreadystatechange = function() {

		if (request.readyState == 4 && request.status == 200) {

			chargerObjetBebe();
		}
	};
	
	/*
	 * Configuration puis envoi de la requete HTTP
	 */
	var inputNom = document.getElementById("nom_objet" + id);
	var type = document.getElementById("type" + id);
	var valeur = document.getElementById("valeur" + id)
	if(type){
		var params = "nom=" + inputNom.value + "&type=" + type.value + "&valeur=" +valeur.value;
	}else{
		var params = "nom=" + inputNom.value + "&valeur=" +valeur.value;
	}
	
	
	request.open("PUT", "http://localhost:8080/BudgetBB/budgetBB/objets/" + id, true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send(params);
}
