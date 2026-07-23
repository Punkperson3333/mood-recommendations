let selectedMood = "";
let selectedType = "";
let selectedMoodButton = null;
let selectedTypeButton = null;

// Recommendation data



// Select mood
function selectMood(mood, button) {

    selectedMood = mood;

    if (selectedMoodButton !== null) {
        selectedMoodButton.classList.remove("selected");
    }

    button.classList.add("selected");

    selectedMoodButton = button;

}



// Select type
function selectType(type, button) {

    selectedType = type;

    if(selectedTypeButton!==null){
        selectedTypeButton.classList.remove("selected");
    }
    button.classList.add("selected");
    selectedTypeButton = button;

}


// Get recommendations
// Get recommendations from MySQL through Spring Boot
function getRecommendations() {

    if (selectedMood === "" || selectedType === "") {
        alert("Please select a mood and choose movies or books.");
        return;
    }

    fetch(
    `https://mood-recommendations-backend.onrender.com/api/recommendations?mood=${encodeURIComponent(selectedMood)}&type=${encodeURIComponent(selectedType)}`
    )
    .then(response => response.json())
    .then(data => {
        displayRecommendations(data);
    })
    .catch(error => {
        console.error("Backend error:", error);
    });
}
function displayRecommendations(results) {

    const recommendationArea =
        document.getElementById("recommendations");


    recommendationArea.innerHTML = "";


    if (results.length === 0) {

        recommendationArea.innerHTML =
            "<p>Uh oh... no recommendations found.....😢😢</p>";

        return;
    }


    results.forEach(function(item) {

        const card = document.createElement("div");

        card.className = "recommendation-card";


        card.innerHTML = `

        <img src="${item.image}" alt="${item.title}">

        <h2>${item.title}</h2>

        <p>Type: ${item.type}</p>

        <p>Genre: ${item.genre}</p>

        <p>⭐ Rating: ${item.rating}</p>

        `;


        recommendationArea.appendChild(card);

    });

}