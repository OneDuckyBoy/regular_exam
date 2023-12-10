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

function  getIfItemIsLiked(id){
    let liked ;
     id = id.substring(5)
    // console.log(id)
    fetch('http://localhost:8080/rest/getIfItemIsLiked/'+id)
        .then(response => response.json())
        .then(json =>{
            liked= json;
            }
        )
    return liked;
}
function  LikeItem(id){
    id = id.substring(5)
    let liked ;
    fetch('http://localhost:8080/rest/addToLiked/'+id)
        .then(response => response.json())
        .then(json =>{
            }
        )
}function  UnlikeItem(id){
    // console.log("unlike "+id)
    id = id.substring(5)
    let liked ;
    fetch('http://localhost:8080/rest/RemoveFromLiked/'+id)
        .then(response => response.json())
        .then(json =>{
            }
        )
}
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

let category= window.location.href[window.location.href.length-1]
// console.log(category)


        items.forEach(item =>{
            // console.log(item)
            let imagePath = item.image.imageLocation;
            let name = item.name;
            let price = item.price;
            let id = "item/"+item.id;
        if (item.category.id==category){
            // console.log(item.category.id)
            let liked= getIfItemIsLiked(id);
            addItem(imagePath,name,price,liked,id)
        }else if (category=='/') {
            let liked= getIfItemIsLiked(id);

            // console.log("else")
            // console.log(item);
            addItem(imagePath,name,price,liked,id)

        }
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

    function addItem(imagePath, itemName,itemPrice,isLiked,url,id){
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
        addToCartBtn.addEventListener('click',()=>{
            // console.log(url)

            let id = url.substring(5)
            console.log(id)

            fetch('http://localhost:8080/rest/addToCart/'+id, {method: 'get'}).then(r  =>console.log("added to cart"))
        })

        let likeContainer = document.createElement('div');
        likeContainer.classList.add('item-text');
        itemContainer.appendChild(likeContainer);
        let heart = document.createElement('button');
        likeContainer.appendChild(heart);
        heart.classList.add('button-2');
        heart.role = 'button';
        console.log(isLiked)
        if (isLiked){
            heart.innerHTML = 'Add to Liked <i class="fa fa-heart liked fa-lg" aria-hidden="true" ></i>';
        }else {
            heart.innerHTML = 'Add to Liked <i class="fa fa-heart-o fa-lg" aria-hidden="true" ></i>';

        }
        heart.addEventListener('click', () => {
            if (heart.classList.contains("liked")) {
                heart.innerHTML = 'Add to Liked <i class="fa fa-heart-o fa-lg" aria-hidden="true"></i>';
                heart.classList.remove("liked");
                // console.log("unliked "+url);
                UnlikeItem(url);
            } else {
                heart.innerHTML = 'Add to Liked <i class="fa fa-heart fa-lg" aria-hidden="true"></i>';
                // console.log("liked "+url);

                LikeItem(url)
                heart.classList.add("liked");
            }
        });
    }
}