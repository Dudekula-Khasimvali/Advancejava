function validateform()
{
	var proId=document.getElementById("proId").value;
	var proName=document.getElementById("proName").value;
	var proPrice=document.getElementById("proPrice").value;
	var proBrand=document.getElementById("proBrand").value;
	var proMadein=document.getElementById("proMadein").value;
	var proMfgdate=document.getElementById("proMfgdate").value;
	var proExpdate=document.getElementById("proExpdate").value;
	
	if(proId.trim()==="" || proName.trim() ==="" || proPrice.trim()==="" || proBrand.trim() ==="" || proMadein.trim() ==="")
	{
		alert("All fields are Must be Filled out");
		return false;
	}
	
	if(parseFloat(proPrice)<0)
	{
		alert("proPrice Must Not be Negative ");
		return false;
	}
	
	if(proName.length > 25 || proBrand.length > 25)
	{
		alert("proName or proBrand out of Length");
		return false;
	}
	
	//convert into date formate
	var manufacturingDateObj = new Date(proMfgdate);
	var expiryDateObj = new Date(proExpdate);
	
	//check the validation of dates
	if(manufacturingDateObj > expiryDateObj)
	{
		alert("MfgDate can't be Greater than ExpDate");
		return false;
	}
	
	return true;
	
	
}