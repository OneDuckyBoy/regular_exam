window.onload = function() {
// container.innerHTML = 'hi';









    addItem(0)
    addItem(0)
    addItem(0)
    addMoreItems(0)
    addItem(1)
    addItem(1)
    addItem(1)
    addMoreItems(1)
    // addItem(2)
    // addItem(2)

    function addMoreItems(num){
        let container = document.getElementsByClassName('items')[num];
        let form = document.createElement("form")
        form.method = "get";
        form.action = "liked";

        let itemContainer = document.createElement('button');
        itemContainer.classList.add('item-container');
        itemContainer.style.background = "white";
        itemContainer.style.margin = "0px";
        itemContainer.style.border = "none";
        itemContainer.type = "submit";

        form.appendChild(itemContainer);
        container.appendChild(form);
        itemContainer.innerHTML = '<div  href="/liked"><i class=\"fa-normal fa-plus fa-8x\"></i></div>';
        // let plusIcon = document.createElement('a')
        // plusIcon.href = "liked";
        // plusIcon.innerHTML+="<i class=\"fa-normal fa-plus fa-8x\"></i>";
        // itemContainer.appendChild(plusIcon)
        let more = document.createElement("p")
        more.innerHTML="More";
        itemContainer.appendChild(more)
        // plusIcon.style.width = "100px"


    }

    function addItem(num){
        let container = document.getElementsByClassName('items')[num];



        let itemContainer = document.createElement('div');
        itemContainer.classList.add('item-container');
        container.appendChild(itemContainer);
        let form = document.createElement("form")
        form.method = "get";
        form.action = "liked";
        let button = document.createElement("button");
    form.appendChild(button)

        itemContainer.style.background = "white";
        itemContainer.style.margin = "0px";
        itemContainer.style.border = "none";
        itemContainer.style.borderRadius = "10px";
        itemContainer.type = "submit";
        let image = document.createElement('img');
        button.appendChild(image)
        image.src = "https://i.postimg.cc/8CmBZH5N/shoes.webp";
        image.alt = "img";
        itemContainer.appendChild(form);
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
        heart.innerHTML = 'Add to Liked <i class="fa fa-heart-o fa-lg" aria-hidden="true" ></i>';
        heart.addEventListener('click', () => {
            if (heart.classList.contains("liked")) {
                heart.innerHTML = 'Add to Liked <i class="fa fa-heart-o fa-lg" aria-hidden="true"></i>';
                heart.classList.remove("liked");
            } else {
                heart.innerHTML = 'Add to Liked <i class="fa fa-heart fa-lg" aria-hidden="true"></i>';
                heart.classList.add("liked");
            }
        });
    }
}