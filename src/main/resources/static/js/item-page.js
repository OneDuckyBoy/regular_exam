// let itemIdP = document.getElementById("item-id");
// console.log(itemIdP)
// let itemId ;
window.onload = function(){
        // let itemIdP = document.getElementById("item-id");
        // itemId = itemIdP.innerHTML;

        load()
}

function load(){



        let itemIdP = document.getElementById("item-id");
        itemId = itemIdP.innerHTML;
        console.log(itemId)
        console.log("hi")
    fetch("http://localhost:8080/rest/getIfItemIsLiked/"+itemId)
        .then(response => response.json())
        .then(r=> {
            let addToLiked = document.getElementById("add-to-liked")

            // console.log(r)
            if (r) {
                addToLiked.innerHTML = "Add to liked <i class=\"fa fa-heart fa-lg\" style=\"color: red\" aria-hidden=\"true\" ></i>"
            }else {
                addToLiked.innerHTML = "Add to liked <i class=\"fa fa-heart-o fa-lg\" style=\"color: red\" aria-hidden=\"true\" ></i>"

            }
        }).then(()=>{
fetch('http://localhost:8080/rest/getItem/'+itemId)
    .then(response => response.json())
    .then(json =>{


            // itemIdP.remove();



        let item=json////[parseInt( itemId)];
            console.log(item)
        let image1 = document.getElementById("image-image");
        // image1.src = item.image.imageLocation

            let imagePath = item.image.imageLocation;
            // let image = document.createElement('img');
            image1.src = "http://localhost:8080/"+imagePath;//"https://i.postimg.cc/8CmBZH5N/shoes.webp";
           console.log(image1)
        console.log(imagePath)
        let itemName = document.getElementsByClassName("item-name")[0];
        itemName.textContent = item.name;
        let description = document.getElementsByClassName("description")[0];
        description.textContent =item.description;
        let price = document.getElementsByClassName("price")[0];
        price.textContent = item.price;
        // console.log(item)
        // console.log(window.location.href)
        let id = item.id;
        let addToCart  =document.getElementById("add-to-cart")
        addToCart.addEventListener("click",()=>{
            fetch('http://localhost:8080/rest/addToCart/'+id, {method: 'get'}).then(r  =>console.log("added to cart"))

        })

        let addToLiked = document.getElementById("add-to-liked")
        //Add to liked <i class="fa fa-heart fa-lg" style="color: red" aria-hidden="true" ></i>
        addToLiked.addEventListener("click",()=>{
            fetch("http://localhost:8080/rest/getIfItemIsLiked/"+id)
                .then(response => response.json())
                .then(r=> {

                    // console.log(r)
                    if (!r) {
                        addToLiked.innerHTML = "Add to liked <i class=\"fa fa-heart fa-lg\" style=\"color: red\" aria-hidden=\"true\" ></i>"
                        LikeItem(id)
                    }else {
                        addToLiked.innerHTML = "Add to liked <i class=\"fa fa-heart-o fa-lg\" style=\"color: red\" aria-hidden=\"true\" ></i>"
                        UnlikeItem(id)
                    }
                })

        })
        function  LikeItem(id){
            // id = id.substring(5)
            console.log("like "+id)
            fetch('http://localhost:8080/rest/addToLiked/'+id)
                .then(response => response.json())
                .then(json =>{

                    }
                )
        }function  UnlikeItem(id){
            console.log("unlike "+id)
            // id = id.substring(5)
            let liked ;
            fetch('http://localhost:8080/rest/RemoveFromLiked/'+id)
                .then(response => response.json())
                .then(json =>{
                    }
                )
        }


            // console.log(json)

            // let name = json.name
            // let price = json.price;
            // let imageLocation1 = json.image.imageLocation;
            // console.log(imageLocation1)
        }
    )
    })
}