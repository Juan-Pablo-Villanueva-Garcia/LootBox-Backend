const telPattern = new RegExp("^\\(?\\d{2}\\)?[-\\s]?\\d{4}[-\\s]?\\d{4}$");
const emailPattern = new RegExp("[^@ \t\r\n]+@[^@ \t\r\n]+\\.[^@ \t\r\n]+");
const passwordPattern = new RegExp("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$");

const txtNombre = document.getElementById("txtNombre");
const txtCorreo = document.getElementById("txtCorreo");
const txtTel = document.getElementById("txtTel");
const txtPassword = document.getElementById("txtPassword");
const txtConfirmar = document.getElementById("txtConfirmar");
const txtDireccion = document.getElementById("txtDireccion"); // <-- nuevo campo
const btnEnviar = document.getElementById("btnEnviar");
const alertValidacionesTexto = document.getElementById("alertValidacionesTexto");
const alertValidaciones = document.getElementById("alertValidaciones");

const imgContainer = document.getElementById("imgContainer");

// Validaciones
function validarNombre() {
    const nombreCompleto = txtNombre.value.trim();
    const partesNombre = nombreCompleto.split(" ");
    return partesNombre.length >= 2 && partesNombre.every(p => p.length > 0);
}

function validarEmail() {
    const content = txtCorreo.value.trim();
    return emailPattern.test(content);
}

function validarTelefono() {
    const content = txtTel.value.trim();
    if (!telPattern.test(content)) return false;
    const limpio = content.replace(/\D/g, '');
    if (limpio.length !== 10) return false;
    const bloque1 = limpio.slice(2, 6);
    const bloque2 = limpio.slice(6, 10);
    const repetidos = /(\d)\1{3}/;
    if (repetidos.test(bloque1) || repetidos.test(bloque2)) return false;
    return telPattern.test(content);
}

function validarPassword() {
    const content = txtPassword.value.trim();
    return passwordPattern.test(content);
}

function coincidenPasswords() {
    return txtPassword.value === txtConfirmar.value;
}

btnEnviar.addEventListener("click", async function(event) {
    event.preventDefault();
    alertValidaciones.style.display = "none";
    alertValidacionesTexto.innerHTML = "";

    txtNombre.style.border = "";
    txtCorreo.style.border = "";
    txtTel.style.border = "";
    txtPassword.style.border = "";
    txtConfirmar.style.border = "";
    txtDireccion.style.border = ""; // <-- limpiar borde de dirección
    document.getElementById('chkTerminos').style.border = "";

    let isValid = true;

    // Validación Nombre
    if (txtNombre.value.trim() === "") {
        txtNombre.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>El nombre y apellido no puede estar vacío.</strong><br/><br/>";
        isValid = false;
    } else if (!validarNombre()) {
        txtNombre.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>Debe ingresar al menos nombre y apellido.</strong><br/><br/>";
        isValid = false;
    }

    // Validación Email
    if (txtCorreo.value.trim() === "") {
        txtCorreo.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>El correo no puede estar vacío.</strong><br/><br/>";
        isValid = false;
    } else if (!validarEmail()) {
        txtCorreo.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>Formato de correo inválido.</strong><br/><br/>";
        isValid = false;
    }

    // Validación Teléfono
    if (txtTel.value.trim() === "") {
        txtTel.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>El teléfono no puede estar vacío.</strong><br/><br/>";
        isValid = false;
    } else if (!validarTelefono()) {
        txtTel.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>Formato de teléfono inválido.</strong><br/><br/>";
        isValid = false;
    }

    // Validación Dirección
    if (txtDireccion.value.trim() === "") {
        txtDireccion.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>La dirección no puede estar vacía.</strong><br/><br/>";
        isValid = false;
    }

    // Validación Contraseña
    if (txtPassword.value.trim() === "") {
        txtPassword.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>La contraseña no puede estar vacía.</strong><br/><br/>";
        isValid = false;
    } else if (!validarPassword()) {
        txtPassword.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula, un número y un símbolo.</strong><br/>";
        isValid = false;
    }

    if (txtConfirmar.value.trim() === "") {
        txtConfirmar.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>Debe confirmar la contraseña.</strong><br/><br/>";
        isValid = false;
    } else if (!coincidenPasswords()) {
        txtConfirmar.style.border = "2px solid red";
        alertValidacionesTexto.innerHTML += "<strong>Las contraseñas no coinciden.</strong><br/><br/>";
        isValid = false;
    }

    // Check Términos
    if (!document.getElementById('chkTerminos').checked) {
        alertValidacionesTexto.innerHTML += "<strong>Debe aceptar los términos y condiciones.</strong>";
        document.getElementById('chkTerminos').style.border = "2px solid red";
        isValid = false;
    }

    if (!isValid) {
        alertValidaciones.style.display = "block";
        imgContainer.style.display = "none";
        return;
    } else {
        alertValidaciones.style.display = "none";
        imgContainer.style.display = "block";
    }

    // backend
    const nuevoUsuario = {
        nombre: txtNombre.value.trim(),
        email: txtCorreo.value.trim(),
        telefono: txtTel.value.trim(),
        password: txtPassword.value.trim(),
        direccion: txtDireccion.value.trim(),  // <-- se agregó direccion
        isAdmin: false
    };

    try {
        // Ejemplo: llamada POST a API REST para registro
        const response = await fetch('/api/usuarios/registro', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(nuevoUsuario)
        });

        if (!response.ok) {
            const errorData = await response.json();
            Swal.fire("Error", errorData.message || "Error al registrar usuario", "error");
            return;
        }

        Swal.fire("Registro exitoso", "El usuario fue guardado correctamente", "success").then(() => {
            window.location.href = "./sesion.html";
        });

        // Limpiar formulario después de registro exitoso
        txtNombre.value = "";
        txtCorreo.value = "";
        txtTel.value = "";
        txtPassword.value = "";
        txtConfirmar.value = "";
        txtDireccion.value = ""; // limpiar direccion
        document.getElementById('chkTerminos').checked = false;
        document.getElementById('chkTerminos').style.border = "";
        txtNombre.focus();

    } catch (error) {
        Swal.fire("Error", "No se pudo conectar con el servidor", "error");
    }
});

