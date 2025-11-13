async function loadReports() {
    const r = await fetch("http://localhost:8088/api/admin/reports");
    const list = await r.json();

    const rows = document.getElementById("rows");
    rows.innerHTML = "";

    list.forEach(rep => {
        rows.innerHTML += `
            <tr>
                <td>${rep.id}</td>
                <td>${rep.crimeType}</td>
                <td>${rep.location}</td>
                <td>${rep.status}</td>

                <td>
                    <button onclick="updateStatus(${rep.id}, 'INVESTIGATING')">Investigate</button>
                    <button onclick="updateStatus(${rep.id}, 'RESOLVED')">Resolved</button>
                </td>

                <td>
                    <button onclick="deleteReport(${rep.id})" style="background:red">Delete</button>
                </td>
            </tr>
        `;
    });
}

async function updateStatus(id, status) {
    await fetch(`http://localhost:8088/api/admin/report/${id}/status?status=${status}`, {
        method: "PUT"
    });
    loadReports();
}

async function deleteReport(id) {
    await fetch(`http://localhost:8088/api/admin/report/${id}`, {
        method: "DELETE"
    });
    loadReports();
}

loadReports();
