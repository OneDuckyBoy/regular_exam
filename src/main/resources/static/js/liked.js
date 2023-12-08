window.onload = function() {
    let container = document.getElementsByClassName('items')[0];
// container.innerHTML = 'hi';
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()
    addItem()

    function addItem(){
        let itemContainer = document.createElement('div');
        itemContainer.classList.add('item-container');
        container.appendChild(itemContainer);
        let image = document.createElement('img');
        image.src = "https://i.postimg.cc/8CmBZH5N/shoes.webp";
        image.alt = "img";
        itemContainer.appendChild(image);
        let name = document.createElement('p');
        name.classList.add('name');
        name.textContent = "ime ime ime";
        itemContainer.appendChild(name);
        let itemText = document.createElement('div');
        itemText.classList.add('item-text');
        itemContainer.appendChild(itemText);

        let price = document.createElement('p');
        price.classList.add('price');
        price.textContent = "5 leva";
        itemText.appendChild(price);
        let addToCartBtn = document.createElement('button');
        addToCartBtn.classList.add('button-2');
        addToCartBtn.role = 'button';
        addToCartBtn.textContent = "Add to Cart";
        itemText.appendChild(addToCartBtn);

        let likeContainer = document.createElement('div');
        likeContainer.classList.add('item-text');
        itemContainer.appendChild(likeContainer);
        let heart = document.createElement('button');
        likeContainer.appendChild(heart);
        heart.classList.add('button-2');
        heart.role = 'button';
        heart.innerHTML = 'Remove from Liked <i class=" fa fa-solid fa-xmark fa-lg " aria-hidden="true" ></i>';
        heart.addEventListener('click', () => {

            // todo

            // if (heart.classList.contains("liked")) {
            //     heart.innerHTML = 'Remove from Liked <i class="fa fa-solid fa-xmark fa-lg" aria-hidden="true"></i>';
            //     heart.classList.remove("liked");
            // } else {
            //     heart.innerHTML = 'Remove from Liked <i class="fa fa-solid fa-xmark fa-lg" aria-hidden="true"></i>';
            //     heart.classList.add("liked");
            // }
        });
    }
}