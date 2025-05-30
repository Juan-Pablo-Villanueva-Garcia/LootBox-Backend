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

   
       const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        const raw = JSON.stringify({
        "email": correo,
        "password": password
        });

        const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
        };

        fetch("/api/login/", requestOptions)
            .then((response) => {
                if (!response.ok) {
                // Si el login falló (por ejemplo, 401 Unauthorized)
                throw new Error("Credenciales incorrectas");
                }
                return response.json();
            })
            .then((result) => {
                const { accesToken } = result;
                sessionStorage.setItem("token", accesToken);
                buscarusuarios(accesToken, raw);
            })
            .catch((error) => {
                Swal.fire("Error", "Correo o contraseña incorrectos. Por favor, intenta nuevamente.", "error");
            });
    
});

//buscarUsuarios
        function buscarusuarios(token,raw){
        const {email} = JSON.parse(raw)
        console.log(email);
        
        const myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer "+token);

                const requestOptions = {
                method: "GET",
                headers: myHeaders,
                redirect: "follow"
                };

                fetch("/api/usuarios/", requestOptions)
                .then((response) => response.json())
                .then(result =>{
            result.forEach(user => {
                if(user.email === email){      
             Swal.fire("Bienvenido", `Hola ${user.nombre}`, "success").then(()=>{
             sessionStorage.setItem("usuarioActivo", JSON.stringify(user));  
             window.location.href = "./index.html";
          });
         }  
            });
        })
        .catch(err=>console.log(err))
    }