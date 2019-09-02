<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Productos</title>
</head>
<body>
	<h2>Lista Productos</h2>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>***Listado de productos***</h1>
	<h3>Links de movimiento</h3>
	<h3>
		<a href="http://localhost:8090/ecommerce/">Vista principal</a>
	</h3>
	<h3>
		<a href="">Consultar las Categorias</a>
	</h3>
	<table border="1" width="100%" cellpadding="10">
	<thead >
		<tr>
			<th>ID</th>
			<th>Product Code</th>
			<th>SKU</th>
			<th>Name product</th>
			<th>Description</th>
			<th>Colour</th>
			<th>Update Date</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Taxes</th>
			<th>Additional Shipping Cost</th>
			<th>Whole Sale Price</th>
			<th>Delivery Date</th>
			<th>Width</th>
			<th>Height</th>
			<th>Depth</th>
			<th>Weight</th>
			<th>Id Order</th>
			<th>Actions</th>
		</tr>
	</thead>
		<c:forEach var="ver" items="${listPro}">
		<tbody>
			<tr>
				<td>${ver.idProducts}</td>
				<td>${ver.productCode}</td>
				<td>${ver.sku}</td>
				<td>${ver.nameProducts}</td>
				<td>${ver.description}</td>
				<td>${ver.colour}</td>
				<td>${ver.updateDate}</td>
				<td>${ver.price}</td>
				<td>${ver.quantity}</td>
				<td>${ver.taxes}</td>
				<td>${ver.additionalShippingCost}</td>
				<td>${ver.wholeSalePrice}</td>
				<td>${ver.productDeliveryDate}</td>
				<td>${ver.width}</td>
				<td>${ver.height}</td>
				<td>${ver.depth}</td>
				<td>${ver.weight}</td>
				<td>${ver.idOrders}</td>
				<td>
				<a href="updatepro/${ver.idProducts}">Edit</a> 
				<br>
				<a href="deletepro/${ver.idProducts}">Delete</a>
				</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
	<br />
</body>
</html>