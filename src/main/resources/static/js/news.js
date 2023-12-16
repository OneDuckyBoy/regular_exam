window.onload = function() {
    // addNews('https://i.postimg.cc/8CmBZH5N/shoes.webp',
    //     'Shoes are trendy now');
    // addNews('https://i.postimg.cc/8CmBZH5N/shoes.webp',
    //     'Shoes are trendy now');
    // addNews('https://i.postimg.cc/8CmBZH5N/shoes.webp',
    //     'Shoes are trendy now');
    function addNews(imageUrl, title1){
        let container = document.getElementById('news');
        let form = document.createElement('form');
        form.action = 'news-page';
        container.appendChild(form);
        let card = document.createElement('button');
        card.type = 'submit';
        card.classList.add('news1');
        form.appendChild(card);
        let imageContainer = document.createElement('div');
        imageContainer.classList.add('image');
        card.appendChild(imageContainer);
        let image = document.createElement('img');
        image.src = imageUrl;
        image.alt = 'img';
        imageContainer.appendChild(image);

        let title = document.createElement('div');
        title.classList.add('name');
        title.classList.add('text');
        title.textContent = title1;
        card.appendChild(title);
    }
}