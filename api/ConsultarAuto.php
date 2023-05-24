<?PHP
$hostname_localhost = "localhost";
$database_localhost = "bd_autos";
$username_localhost = "root";
$password_localhost = "";
$json = array();
if (isset($_GET["id"])) {
    $id = $_GET["id"];
    $conexion =
        mysqli_connect($hostname_localhost, $username_localhost, $password_localhost, $database_localhost);
    $consulta = "select u.id, u.conductor, m.marca, n.modelo, c.color, u.imagen,u.rutaImagen 
    from auto u INNER join marca m on u.idmarca = m.idmarca 
                INNER join modelo n on u.idmodelo = n.idmodelo 
                INNER join color c on u.idcolor = c.idcolor
                where u.id= '{$id}'";

    $resultado = mysqli_query($conexion, $consulta);
    if ($registro = mysqli_fetch_array($resultado)) {
        $result["id"] = $registro['id'];
        $result["conductor"] = $registro['conductor'];
        $result["marca"] = $registro['marca'];
        $result["modelo"] = $registro['modelo'];
        $result["color"] = $registro['color'];
        $result["rutaImagen"] = $registro['rutaImagen'];
        $result["imagen"] = base64_encode($registro['imagen']);
        $json['auto'][] = $result;
    } else {
        $resultar["id"] = 0;
        $resultar["conductor"] = 'no registra';
        $resultar["imagen"] = 'no registra';
        $json['auto'][] = $resultar;
    }
    mysqli_close($conexion);
    echo json_encode($json);
} else {
    $resultar["success"] = 0;
    $resultar["message"] = 'Ws no Retorna';
    $json['auto'][] = $resultar;
    echo json_encode($json);
}
