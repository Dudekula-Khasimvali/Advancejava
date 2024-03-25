<%@ page import="com.khasim.project.ProductsDao" import ="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title> Edit-Product List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body> 
	<div class="container mt-5 text-center">
    <h2 class="text-center font-italic mb-1">BGMI Gaming Kit</h2>
    <form action="UpdateProductServlet" method="post" enctype="multipart/form-data"  onsubmit="return validateform()">
            
	<div class="form-group">
    <label class="font-italic font-weight-bold" for="proId">Product ID:</label>
    <input type="text" class="form-control-sm" id="proId" name="proId"  placeholder="Enter The ID"  value='${existingObject.proId }'  required>
	</div>

	
	<div  class="form-group">
	<label class="font-italic font-weight-bold" for="proName">Product Name:</label>
	<input type="text" class="form-control-sm" id="proName"  name="proName"   placeholder="Enter The Name"  value='${existingObject.proName }' required>
	</div>
	
	<div class="form-group">
    <label class="font-italic font-weight-bold" for="proPrice">Product Price:</label>
    <input type="text" class="form-control-sm" id="proPrice" name="proPrice" placeholder="Enter The Price" value='${existingObject.proPrice }' required>
	</div>
	
	<!-- Brand -->
	<div class="form-group">
    <label class="font-italic font-weight-bold" for="proBrand">Product Brand:</label>
    <input type="text" class="form-control-sm" id="proBrand" name="proBrand"  placeholder="Enter The Brand" value='${existingObject.proBrand }' required>
	</div>
	
	<!-- Made IN -->
	<div class="form-group">
    <label class="font-italic font-weight-bold" for="proMadein">Product MadeIn:</label>
    <input type="text" class="form-control-sm" id="proMadein" name="proMadein"  placeholder="Enter The MadeIn" value='${existingObject.proMadein }' required>
	</div>
	
	<!-- Mfg Date -->
	<div class="form-group">
    <label class="font-italic font-weight-bold" for="proMfgdate">Product Mfg-Date:</label>
    <input type="date" class="form-control-sm" id="proMfgdate" name="proMfgdate"  placeholder="Enter The Date" value='${existingObject.proMfgdate }' required>
	</div>
	
	<!-- Exp Date -->
	<div class="form-group">
    <label class="font-italic font-weight-bold" for="proExpdate">Product Exp-Date:</label>
    <input type="date" class="form-control-sm" id="proExpdate" name="proExpdate" placeholder="Enter The Date" value='${existingObject.proExpdate }' required>
	</div>
	
	<!-- Display Current Image -->
<div class="form-group">
    <label class="font-italic font-weight-bold" for="proImage">Current Product Image:</label>
    <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingObject.proImage)}" alt="current product image" style="max-width:100px; max-height:100px;">
    <input type="hidden" id="existingImage" name="existingImage" value="${Base64.getEncoder().encodeToString(existingObject.proImage)}">
</div>

<!-- Display New Image -->
<div class="form-group">
    <label class="font-italic font-weight-bold" for="newproImage">New Product Image:</label>
    <input type="file" class="form-control-file-sm" id="newproImage" name="newproImage" accept="image/*">
</div>



	<!-- Submit -->
	<div >
    <input type="Submit" class="btn btn-success" value="Update product" >
	</div>
	
	
</form>
</div>
</body>
</html>