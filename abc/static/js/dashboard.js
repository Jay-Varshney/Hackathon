// Employees data (mock industry-style data)
const employees = [
    { name: "Alice Johnson", role: "Frontend Developer", skills: "React, CSS", status: "active" },
    { name: "Bob Smith", role: "Backend Developer", skills: "Java, Spring", status: "busy" },
    { name: "Diana Lee", role: "UI/UX Designer", skills: "Figma, UX", status: "available" },
    { name: "Chris Brown", role: "DevOps Engineer", skills: "AWS, Docker", status: "active" },
    { name: "Evan White", role: "Data Engineer", skills: "Python, SQL", status: "busy" }
];

// Populate employee table
const table = document.getElementById("employeeTable");

employees.forEach(emp => {
    const row = document.createElement("tr");

    row.innerHTML = `
        <td>${emp.name}</td>
        <td>${emp.role}</td>
        <td>${emp.skills}</td>
        <td><span class="status ${emp.status}">${emp.status.toUpperCase()}</span></td>
    `;

    table.appendChild(row);
});

// Charts
new Chart(document.getElementById("skillsChart"), {
    type: "bar",
    data: {
        labels: ["Frontend", "Backend", "DevOps", "Design", "Data"],
        datasets: [{
            label: "Employees",
            data: [10, 12, 6, 5, 4]
        }]
    }
});

new Chart(document.getElementById("projectChart"), {
    type: "doughnut",
    data: {
        labels: ["Assigned", "Available"],
        datasets: [{
            data: [34, 8]
        }]
    }
});