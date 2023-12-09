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



            // console.log(json)

            // let name = json.name
            // let price = json.price;
            // let imageLocation1 = json.image.imageLocation;
            // console.log(imageLocation1)
        }
    )
}