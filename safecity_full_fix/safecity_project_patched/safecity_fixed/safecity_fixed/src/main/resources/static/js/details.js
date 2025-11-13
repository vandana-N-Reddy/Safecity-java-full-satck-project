const url = new URL(window.location.href);
const id = url.searchParams.get("id");

async function loadDetail() {
    const r = await fetch("http://localhost:8088/api/reports/" + id);
    const data = await r.json();

    document.getElementById("crimeType").textContent = data.crimeType;
    document.getElementById("location").textContent = data.location;
    document.getElementById("description").textContent = data.description;
    document.getElementById("status").textContent = data.status;

    const map = L.map('map').setView([data.latitude, data.longitude], 14);
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(map);

    L.marker([data.latitude, data.longitude]).addTo(map);
}

loadDetail();
