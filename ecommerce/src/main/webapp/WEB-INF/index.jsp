<html>
<body>
	<h2>Hello World!</h2>

	<form action="products" method="post">
		<table>
			<tr>
				<td>Codigo del producto:</td>
				<td><input type="text" name="productCode"></td>
			</tr>
			<tr>
				<td>sku(Identificador unico de almacenamiento):</td>
				<td><input type="text" name="sku"></td>
			</tr>
			<tr>
				<td>Nombre del producto:</td>
				<td><input type="text" name="nameProducts"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Color:</td>
				<td><input type="text" name="colour"></td>
			</tr>
			<tr>
				<td>Fecha de actualización:</td>
				<td><input type="date" name="updateDate"></td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<td>Cantidad:</td>
				<td><input type="number" name="quantity"></td>
			</tr>
			<tr>
				<td>Impuestos:</td>
				<td><input type="number" name="taxes"></td>
			</tr>
			<tr>
				<td>Costos adicionales de envío:</td>
				<td><input type="number" name="additionalShippingCost"></td>
			</tr>
			<tr>
				<td>Precio de venta total:</td>
				<td><input type="number" name="wholeSalePrice"></td>
			</tr>
			<tr>
				<td>Fecha de entrega:</td>
				<td><input type="date" name="productDeliveryDate"></td>
			</tr>
			<tr>
				<td>Ancho:</td>
				<td><input type="number" name="width"></td>
			</tr>
			<tr>
				<td>Alto:</td>
				<td><input type="number" name="height"></td>
			</tr>
			<tr>
				<td>Profundidad:</td>
				<td><input type="number" name="depth"></td>
			</tr>
			<tr>
				<td>Peso:</td>
				<td><input type="number" name="weight"></td>
			</tr>
			<tr>
				<td>ID de la orden:</td>
				<td><input type="number" name="idOrders"></td>
			</tr>
			<tr>
				<td><input type="submit" name="Guardar" value=Guardar></td>
			</tr>
		</table>
	</form>
	<a href="listP">Consultar lista de productos</a>
</body>
</html>
