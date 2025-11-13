// 🌍 Initialize World Map
const map = L.map('map').setView([20, 0], 2);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 18
}).addTo(map);

let marker;

map.on('click', function (e) {
    const lat = e.latlng.lat;
    const lng = e.latlng.lng;

    document.getElementById("latitude").value = lat;
    document.getElementById("longitude").value = lng;

    if (marker) marker.remove();
    marker = L.marker([lat, lng]).addTo(map);
});

// ✅ Submit report
async function submitReport() {
    const dto = {
        reporterName: document.getElementById("reporterName").value,
        location: document.getElementById("location").value,
        latitude: parseFloat(document.getElementById("latitude").value),
        longitude: parseFloat(document.getElementById("longitude").value),
        crimeType: document.getElementById("crimeType").value,
        description: document.getElementById("description").value
    };

    const res = await fetch("http://localhost:8088/api/reports", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dto)
    });

    if (res.ok) {
        alert("Report submitted successfully.");
        window.location.href = "services.html";
    } else {
        alert("Failed to submit.");
    }
}
