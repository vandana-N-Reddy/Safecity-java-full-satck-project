const map2 = L.map('map').setView([20, 0], 2);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(map2);

async function loadReports() {
    const r = await fetch("http://localhost:8088/api/reports");
    const list = await r.json();

    const rows = document.getElementById("reportRows");
    rows.innerHTML = "";

    list.forEach(report => {
        if (report.latitude && report.longitude) {
            L.marker([report.latitude, report.longitude])
                .addTo(map2)
                .bindPopup(`<b>${report.crimeType}</b><br>${report.location}<br>Status: ${report.status}`);
        }

        rows.innerHTML += `
            <tr>
                <td>${report.id}</td>
                <td>${report.crimeType}</td>
                <td>${report.location}</td>
                <td>${report.status}</td>
                <td><a href="report-details.html?id=${report.id}">View</a></td>
            </tr>
        `;
    });
}

loadReports();
