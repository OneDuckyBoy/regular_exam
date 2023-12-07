let cartContainer;
window.onload = function() {
    cartContainer = document.getElementById('cart-container');
    // console.log(cartContainer);

    let container = document
        // .querySelector('cart-items');
        // .getElementsByClassName("cart-items");
        .createElement("div");
// let cartContainer = document.getElementById("cart-container");
    container.classList.add("cart-items");
// .getElementById("test-container");
//     let body = document.getElementsByClassName("body")[0];
//     body.appendChild(container);
    cartContainer.appendChild(container);
    addItem();
    addItem();
    addItem();
    function addItem(){
        let ItemContainer = document.createElement("div");
        ItemContainer.classList.add("ItemContainer");
        container.appendChild(ItemContainer);
        let imageContainer = document.createElement("div");
        imageContainer.classList.add("ImageContainer");

        let image = document.createElement("img");
        image.src = "https://i.postimg.cc/8CmBZH5N/shoes.webp";
        image.alt = "img";
        image.classList.add("image");
        imageContainer.appendChild(image);
        ItemContainer.appendChild(imageContainer);

        let nameContainer = document.createElement("div");
        nameContainer.classList.add("name");
        ItemContainer.appendChild(nameContainer);
        // nameContainer.innerHTML='<p class="name text">ime ime ime </p>';
        let name1 = document.createElement("p");

        name1.classList.add("name");
        name1.classList.add("text");
        name1.textContent = "ime ime ime";
        nameContainer.appendChild(name1);

        let priceContainer = document.createElement("div");
        // priceContainer.innerHTML = "price";
        priceContainer.classList.add("price");
        priceContainer.classList.add("text");
        let price = document.createElement("p");
        price.innerHTML = 5+" leva";
        priceContainer.appendChild(price);
        ItemContainer.appendChild(priceContainer);

        let buttonsContainer = document.createElement("div");
        ItemContainer.appendChild(buttonsContainer);
        buttonsContainer.classList.add("buttons-container");
        let removeFromCart_BTN = document.createElement("button");
        buttonsContainer.appendChild(removeFromCart_BTN);
        removeFromCart_BTN.classList.add("button-2");
        removeFromCart_BTN.classList.add("remove-from-cart");
        removeFromCart_BTN.textContent = "Remove from cart";
        removeFromCart_BTN.role = "button";
        let like_BTN = document.createElement("button");
        buttonsContainer.appendChild(like_BTN);
        like_BTN.classList.add("button-2");
        like_BTN.classList.add("like-btn");
        like_BTN.innerHTML = 'Add to Liked <i class="fa fa-heart-o fa-lg" aria-hidden="true" ></i>';
        like_BTN.role = "button";


        like_BTN.addEventListener('click', () =>{
            if(like_BTN.classList.contains("liked")){
                like_BTN.innerHTML='Add to Liked <i class="fa fa-heart-o fa-lg" aria-hidden="true"></i>';
                like_BTN.classList.remove("liked");
            }else{
                like_BTN.innerHTML='Add to Liked <i class="fa fa-heart fa-lg" aria-hidden="true"></i>';
                like_BTN.classList.add("liked");
            }
        });
    }

}