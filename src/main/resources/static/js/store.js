let items;
// getImage(1)

fetch('http://localhost:8080/rest/getAllItems')
    .then(response => response.json())
    .then(json =>{
        // console.log(json)
        items=json;
        // let name = json.name
        // let price = json.price;
        // let imageLocation1 = json.image.imageLocation;
        // console.log(imageLocation1)
        }
    )
    .catch(error => console.log("error",error));
function getImage(id){
    fetch('http://localhost:8080/rest/getImage/'+id)
        .then(response => response.json())
        .then(json =>{
                // console.log(json)
            let img1 = json.imageLocation;

                // console.log(img1)

            }
        )
        // .catch(error => console.log("error",error));
}
window.onload = function() {
    let container = document.getElementsByClassName('items')[0];
// container.innerHTML = 'hi';


    items.forEach(item =>{

        console.log(item);
        let imagePath = item.image.imageLocation;
        let name = item.name;
        let price = item.price;
        let id = item.id;

        addItem(imagePath,name,price,true,id)

    })



    // getImage(1)






    // addItem("images/uploads/ducki the duck.jpg","ducki the duck", 10,true,"liked")
    // addItem("images/uploads/ducki the duck.jpg","ducki the duck", 10,true,"cart")
    // addItem("images/uploads/ducki the duck.jpg","ducki the duck", 10,true)
    // addItem("images/uploads/ducki the duck.jpg","ducki the duck", 10,true)
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()
    // addItem()

    function addItem(imagePath, itemName,itemPrice,isLiked,url){
        let itemContainer = document.createElement('div');
        itemContainer.classList.add('item-container');

        let form = document.createElement('form');
        form.action = url;
        form.method = "get";
        container.appendChild(itemContainer);
        itemContainer.appendChild(form)
        let button = document.createElement("button");
        form.appendChild(button)
        button.style.background = "white";
        button.style.margin = "0px";
        button.style.border = "none";
        button.style.borderRadius = "10px";
        button.type = "submit";
        button.style.cursor="pointer";

        let image = document.createElement('img');
        image.src = imagePath;//"https://i.postimg.cc/8CmBZH5N/shoes.webp";
        image.alt = "img";
        button.appendChild(image);
        let name = document.createElement('p');
        name.classList.add('name');
        name.textContent = itemName;
        itemContainer.appendChild(name);
        let itemText = document.createElement('div');
        itemText.classList.add('item-text');
        itemContainer.appendChild(itemText);

        let price = document.createElement('p');
        price.classList.add('price');
        price.textContent = itemPrice+" leva";
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
        if (isLiked){
            heart.innerHTML = 'Add to Liked <i class="fa fa-heart liked fa-lg" aria-hidden="true" ></i>';
        }else {
            heart.innerHTML = 'Add to Liked <i class="fa fa-heart-o fa-lg" aria-hidden="true" ></i>';

        }
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