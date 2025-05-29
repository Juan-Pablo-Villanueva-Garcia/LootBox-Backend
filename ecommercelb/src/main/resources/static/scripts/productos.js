const main = document.getElementsByTagName("main").item(0);
const modalTitulo = document.getElementById("modalTitulo");
const modalBody = document.getElementsByClassName("modal-body").item(0);
const ulMenu = document.getElementById("ulMenu");
const filtro = document.getElementById("filtro-categoria");

//Función para obtener y mostrar los datos
function cargarProductos() {

  fetch("/api/categorias/")
    .then(res=>res.json())
    .then(prod => prod.forEach(insertarCategorias))
    .catch(err=>console.error(err));

  articulosDefault();

}//cargarProductos()

function articulosDefault(){
  fetch("/api/prod/")
    .then(res=>res.json())
    .then(prod => prod.forEach(createCards))
    .catch(err=>console.error(err));
}//articulosDefault()

function insertarCategorias(prod){
  filtro.insertAdjacentHTML("beforeend",`
      <option value="${prod.id}">${prod.nombre}</option>
    `);
}

//Carga las tarjetas en el main a partir de un objeto tipo prods
function createCards(prods) {
  const calif = JSON.parse(prods.json.replace("\\",""));
  main.insertAdjacentHTML(
    "beforeend",
    `
      <div id="${prods.id}" class="card p-3 text-white bg-dark d-flex flex-column justify-content-between" style="width: 18rem;" data-categoria="${prods.category}">
        <div class="ratio ratio-1x1">
          <img src="${prods.imagen}" class="card-img-top" alt="">
        </div>
        <div class=" h-100 card-body d-flex flex-column flex-wrap justify-content-between gap-3">

          <h5 class="card-title text-center">${prods.name}</h5>       
          <p class="card-text d-none">${prods.descripcion}</p>
          <button class="btn btn-primary add-cart-button" onclick="handleAddToCartClick(event);">
            <i class="bi bi-cart-plus"></i>
          </button>
          
        </div>

        <ul class="list-group list-group-flush text-center" >
          <li class="list-group-item text-white bg-dark">$ ${prods.price}</li>
          <li class="list-group-item text-white bg-dark">⭐ ${calif.rate} (${calif.count})</li>
        </ul>

        <button type="button" onclick="modalProducto(event);" class="btn fs-3 btn-transparent text-white btn-puntos border-0" 
          data-bs-toggle="modal" data-bs-target="#modalDescripcion" >
             <p class="puntos">. . .</p>
        </button>

      </div>
      `
  );//insertAdjacentHTML
} //createCards()

function modalProducto(event) {

  event.preventDefault();
  const contenedorPadre = event.target.closest("div.card");
  modalDescripcion.removeAttribute("inert");
  modalTitulo.innerText = contenedorPadre
    .getElementsByTagName("h5")
    .item(0)
    .innerText.trim();
  modalBody.innerText = contenedorPadre
    .getElementsByTagName("p")
    .item(0)
    .innerText.trim();
  modalDescripcion.querySelector("button").focus();

};//modalProducto

// Filtro por categoría
function aplicarFiltroCategoria() {
  main.innerHTML = '';
  const categoriaSeleccionada = filtro.value;
  if(categoriaSeleccionada!=="0")
   fetch("/api/categorias/"+categoriaSeleccionada)
    .then(res=>res.json())
    .then(prod => prod.productos.forEach(createCards))
    .catch(err=>console.error(err));
  else
      articulosDefault();
}

document.getElementById("filtro-categoria").addEventListener("change", aplicarFiltroCategoria);
document.addEventListener("DOMContentLoaded", cargarProductos);

