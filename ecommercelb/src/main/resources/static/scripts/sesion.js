const txtCorreo = document.getElementById("txtCorreo");
const txtPassword = document.getElementById("txtPassword");
const btnEnviar = document.getElementById("btnEnviar");
const alertValidacionesTexto = document.getElementById("alertValidacionesTexto");
const alertValidaciones = document.getElementById("alertValidaciones");


// Iniciar sesión

// Si ya inició sesión, ya no volver a iniciar
if (sessionStorage.getItem("usuarioActivo")) {
    window.location.href = "./index.html";
}

btnEnviar.addEventListener("click", function (event) {
    event.preventDefault();

    alertValidaciones.style.display = "none";
    alertValidacionesTexto.innerHTML = "";
    txtCorreo.style.border = "";
    txtPassword.style.border = "";
    let isValid = true;

    // Validación campos vacíos
    const correo = txtCorreo.value.trim();
    if (correo === "") {
        txtCorreo.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>El correo no puede estar vacío.</strong><br/><br/>";
        isValid = false;
    }

    const password = txtPassword.value.trim();
    if (password === "") {
        txtPassword.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>La contraseña no puede estar vacía.</strong><br/><br/>";
        isValid = false;
    }

    if (!isValid) {
        alertValidaciones.style.display = "block";
        return;
    }

    // Verificación de usuario

    //const usuarios = JSON.parse(localStorage.getItem('users')) || [];
    // const usuarioEncontrado = usuarios.find(usuario =>
    //      === correo.toLowerCase() &&
    //      === password
    // );
   

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "email": `${correo}`,
        "password": `${password}`
    });

    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("/api/login/", requestOptions)
        .then((response) => response.json())
        .then((result) => {
            sessionStorage.setItem("Authorization",`Bearer: ${result.accesToken}`);

            const headerUsuario = new Headers();
            headerUsuario.append("Authorization", sessionStorage.getItem("Authorization"));

            const requestOptions = {
                method: "GET",
                headers: headerUsuario,
                redirect: "follow"
            };

            fetch(`/api/usuarios/${correo}`, requestOptions)
            .then((response) => response.json())
            .then((usuario) => {
                console.log(usuario);
                sessionStorage.setItem("usuario",JSON.stringify(usuario));
                usuarioValidado();
            })
            .catch((error) => console.error(error));
        })
        .catch((error) => console.error(error));
});


function usuarioValidado(){
    const usuarioEncontrado = JSON.parse(sessionStorage.getItem("usuario"))||null;
    if (usuarioEncontrado) {
        Swal.fire("Bienvenido", `Hola ${usuarioEncontrado.nombre}`, "success").then(()=>{
            sessionStorage.setItem("usuarioActivo", JSON.stringify(usuarioEncontrado));  
            window.location.href = "./index.html";
            
        });
    } else {
        const correoExiste = usuarios.some(usuario => usuario.email.toLowerCase() === correo.toLowerCase());

        if(correoExiste){
            Swal.fire("Error", "Correo o contraseña incorrectos. Por favor, intenta nuevamente.", "error");
        } else {
            Swal.fire({
                title: "Correo no registrado",
                text: "Este correo no está registrado. ¿Deseas crear una cuenta?",
                showCancelButton: true,
                confirmButtonText: "Ir al registro",
                cancelButtonText: "Cancelar"
            }).then((result)=> {
                if(result.isConfirmed) {
                    window.location.href ="./registro.html"
                }
            })  
        }
        
    }
}
