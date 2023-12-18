let totalPrice;

let cartContainer;


window.onload = function() {



    fetch('http://localhost:8080/rest/getItemsInCart')
        .then(response => response.json())
        .then(json =>{
            let arr1 =[];
            fetch('http://localhost:8080/rest/getLikedItemsInCart')
                .then(response1 => response1.json())
                .then(json1 =>{
                    console.log(json1)
                    console.log(json)

                    json1.forEach(item =>{
                        arr1.push(item.id)
                    })

                    all(json,arr1)


                })

        })
    function all (json,json1){
        let deliveryPrice = 5;
        let beginningPrice = deliveryPrice;
        totalPrice = document.getElementById("total-price")
        cartContainer = document.getElementById('cart-container');

        let container = document
            .createElement("div");
        container.classList.add("cart-items");
        cartContainer.appendChild(container);
        let countMap = new Map();
        let arr = [];
        json.forEach(item =>{
            // addItem("images/uploads/ducki the duck.jpg", "Ducki the duck", 10, 1, 4);
            if (countMap.has(item.id)){
                countMap.set(item.id,countMap.get(item.id)+1);
                // console.log("the item with id has ")
            }else {
                countMap.set(item.id,1);
            }
        })
        console.log(json1)
        json.forEach(item =>{
            if (!arr.includes(item.id)){
                addItem(item.image.imageLocation, item.name, item.price, countMap.get(item.id), item.id);
            }
            arr.push(item.id);

        })

        function addItem(imageLocation, itemName, ItemPrice, itemCount, id) {
            let ItemContainer = document.createElement("div");
            ItemContainer.classList.add("ItemContainer");
            container.appendChild(ItemContainer);
            let imageContainer = document.createElement("div");
            imageContainer.classList.add("ImageContainer");

            let image = document.createElement("img");
            // image.src = "https://i.postimg.cc/8CmBZH5N/shoes.webp";
            image.src = imageLocation;
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
            // name1.textContent = "ime ime ime";
            name1.textContent = itemName;
            nameContainer.appendChild(name1);

            let priceContainer = document.createElement("div");
            // priceContainer.innerHTML = "price";
            priceContainer.classList.add("price");
            priceContainer.classList.add("text");
            let price = document.createElement("p");
            // let pricePerItem = 6;
            let pricePerItem = ItemPrice;
            price.innerHTML = pricePerItem + " leva";
            priceContainer.appendChild(price);
            ItemContainer.appendChild(priceContainer);


            let counterContainer = document.createElement("div");
            ItemContainer.appendChild(counterContainer);
            counterContainer.classList.add("counter");
            counterContainer.classList.add("text");
            // counterContainer.classList.add("center");
            // counterContainer.textContent = "Hi";

            //<div class="counter-center counter-container">
            let counterCenter = document.createElement("div");
            counterContainer.appendChild(counterCenter);
            counterCenter.classList.add("counter-center");
            counterCenter.classList.add("counter-container");

            let minusBtn = document.createElement("button");
            minusBtn.classList.add("counter-button");
            minusBtn.classList.add("minus-btn");
            counterCenter.appendChild(minusBtn);
            minusBtn.textContent = "-";

            let counterContainerNumber = document.createElement("div");
            // counterContainerNumber.classList.add("counter-number");
            counterCenter.appendChild(counterContainerNumber);

            let counterNumber = document.createElement("p");
            counterContainerNumber.appendChild(counterNumber);
            counterNumber.classList.add("counter-number");
            counterNumber.innerHTML = "0";


            let plusBtn = document.createElement("button");
            plusBtn.classList.add("counter-button");
            plusBtn.classList.add("plus-btn");
            counterCenter.appendChild(plusBtn);
            plusBtn.textContent = "+";

            // let countNum = 1;
            let countNum = itemCount;
            counterNumber.innerHTML = countNum;

            minusBtn.addEventListener("click", () => {
                if (countNum > 1) {
                    totalPrice.innerHTML = parseInt(totalPrice.textContent) - pricePerItem;

                    countNum -= 1;
                }
                counterNumber.innerHTML = countNum;
            });

            plusBtn.addEventListener("click", () => {
                countNum += 1;
                totalPrice.innerHTML = parseInt(totalPrice.textContent) + pricePerItem;
                counterNumber.innerHTML = countNum;
            });

            beginningPrice += pricePerItem * parseInt(counterNumber.innerHTML);
            totalPrice.innerHTML = beginningPrice+" "
            console.log(beginningPrice);
            let buttonsContainer = document.createElement("div");
            ItemContainer.appendChild(buttonsContainer);
            buttonsContainer.classList.add("buttons-container");
            let removeFromCart_BTN = document.createElement("button");
            buttonsContainer.appendChild(removeFromCart_BTN);
            removeFromCart_BTN.classList.add("button-2");
            removeFromCart_BTN.classList.add("remove-from-cart");
            removeFromCart_BTN.textContent = "Remove from cart";
            removeFromCart_BTN.role = "button";
            removeFromCart_BTN.addEventListener("click",()=>{
                fetch('http://localhost:8080/rest/RemoveFromCart/'+id)
                    .then(response => response.json())
                    .then(json =>{
                        location.reload()
                        }
                    )
            })
            let like_BTN = document.createElement("button");
            buttonsContainer.appendChild(like_BTN);
            like_BTN.classList.add("button-2");
            like_BTN.classList.add("like-btn");



            let liked=false;
                if (json1.includes(id) ){
                    console.log()
                    liked=true;
                }
            if (liked){
                like_BTN.innerHTML = 'Add to Liked <i class="fa fa-heart fa-lg" aria-hidden="true" ></i>';

            }else {
                like_BTN.innerHTML = 'Add to Liked <i class="fa fa-heart-o fa-lg" aria-hidden="true" ></i>';

            }
            like_BTN.role = "button";


            like_BTN.addEventListener('click', () => {
                if (like_BTN.classList.contains("liked")) {
                    like_BTN.innerHTML = 'Add to Liked <i class="fa fa-heart-o fa-lg" aria-hidden="true"></i>';
                    like_BTN.classList.remove("liked");
                    UnlikeItem(id)
                } else {
                    like_BTN.innerHTML = 'Add to Liked <i class="fa fa-heart fa-lg" aria-hidden="true"></i>';
                    like_BTN.classList.add("liked");
                    LikeItem(id)

                }
            });
        }

        let checkoutBtn = document.getElementById("checkout-btn")
        let totalPrice1 = document.getElementById("total-price")
        console.log(checkoutBtn)
        console.log(totalPrice1.innerHTML)
        checkoutBtn.addEventListener("click",()=>{
            console.log(totalPrice1.innerHTML)
            fetch("http://localhost:8080/setCartPrice/"+totalPrice1.innerHTML)
                .then(response => response.json())
        })
        function  LikeItem(id){
            fetch('http://localhost:8080/rest/addToLiked/'+id)
                .then(response => response.json())
                .then(json =>{

                    }
                )
        }function  UnlikeItem(id){
            let liked ;
            fetch('http://localhost:8080/rest/RemoveFromLiked/'+id)
                .then(response => response.json())
                .then(json =>{
                    }
                )
        }
    }
}