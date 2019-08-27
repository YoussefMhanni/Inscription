<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>



<form method="post" action="Serv">


<fieldset> 
<legend>Fiche d'inscription</legend>
Vous pouvez inscrire via ce formulaire
<br>


<br>
<label>Adresse email<span class="requis">*</span> </label>
<input type="text" id="email" name="email" size="30" maxlength="30" value="${client.email }"> 
<span class="requis"> ${form.erreurs['err_email'] }</span> 

<br>
<label>Mot de passe <span class="requis">*</span></label>
<input type="password" id="pass"  name="pass" size="30" maxlength="30" >
<span class="requis"> ${form.erreurs['err_pass'] }</span> 

<br>
<label>Confirmation du mot passe <span class="requis">*</span> </label>
<input type="password" id="conf" name="conf" size="30" maxlength="30">

<br>
<label>Nom d'utilisateur <span class="requis">*</span></label>
<input type="text" id="nom" name="nom" size="30" maxlength="30" value="${client.getNom()}">
 
<span class="requis"> ${form.erreurs['err_nom'] }</span>   
<br>
<input type="submit" id="nomClient"  value="Inscription" name="" size="30" maxlength="30">
<br>
<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.getResultat()}</p>



</fieldset>

</form>
</body>
</html>