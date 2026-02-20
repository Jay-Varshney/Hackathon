let pieChart, barChart;

document.addEventListener("DOMContentLoaded", () => {
    loadDashboardData();
});

function loadDashboardData() {
    fetch("/api/dashboard") // backend endpoint (you create later)
        .then(res => res.json())
        .then(data => {
            updateStats(data);
            renderPieChart(data);
            renderBarChart(data);
            renderTeams(data.recentTeams);
        })
        .catch(err => console.error("Dashboard load failed:", err));
}

function updateStats(data) {
    document.getElementById("totalEmployees").innerText = data.totalEmployees;
    document.getElementById("totalProjects").innerText = data.totalProjects;
    document.getElementById("availableProjects").innerText = data.availableProjects;
}

function renderPieChart(data) {
    const ctx = document.getElementById("projectPie");

    pieChart?.destroy();

    pieChart = new Chart(ctx, {
        type: "pie",
        data: {
            labels: ["Assigned", "Available"],
            datasets: [{
                data: [data.assignedProjects, data.availableProjects],
                backgroundColor: ["#3b82f6", "#10b981"]
            }]
        }
    });
}

function renderBarChart(data) {
    const ctx = document.getElementById("skillsBar");

    barChart?.destroy();

    barChart = new Chart(ctx, {
        type: "bar",
        data: {
            labels: data.skills.map(s => s.name),
            datasets: [{
                label: "Employees",
                data: data.skills.map(s => s.count),
                backgroundColor: "#6366f1"
            }]
        },
        options: {
            scales: { y: { beginAtZero: true } }
        }
    });
}

function renderTeams(teams) {
    const container = document.getElementById("teamsContainer");
    container.innerHTML = "";

    teams.forEach(team => {
        const div = document.createElement("div");
        div.className = "team-card";

        div.innerHTML = `
            <h4>${team.projectName}</h4>
            <ul>
                ${team.members.map(m => `<li>${m}</li>`).join("")}
            </ul>
        `;

        container.appendChild(div);
    });
}