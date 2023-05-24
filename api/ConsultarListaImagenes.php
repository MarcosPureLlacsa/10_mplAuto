<?PHP
$hostname_localhost = "localhost";
$database_localhost = "bd_autos";
$username_localhost = "root";
$password_localhost = "";
$json = array();
$conexion =
    mysqli_connect(
        $hostname_localhost,
        $username_localhost,
        $password_localhost,
        $database_localhost
    );
$consulta = "select * from auto";
$resultado = mysqli_query($conexion, $consulta);
while ($registro = mysqli_fetch_array($resultado)) {
    $result["id"] = $registro['id'];
    $result["conductor"] = $registro['conductor'];
    $result["imagen"] = base64_encode($registro['imagen']);
    $json['auto'][] = $result;
    //echo $registro['id'].' - '.$registro['nombre'].'<br/>';
}
mysqli_close($conexion);
echo json_encode($json);