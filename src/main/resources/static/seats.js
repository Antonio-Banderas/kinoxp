const container = document.querySelector('.container');
let rows = document.getElementsByClassName("row");
let cinema = document.querySelector('.cinema').textContent;
console.log(cinema);

//Seat click event
container.addEventListener('click', e => {
    if (e.target.classList.contains('seat') &&
        !e.target.classList.contains('occupied')) {
        e.target.classList.toggle('selected');
    }
});


createGrid(cinema);
function createGrid(cinema) {
    let rows, columns;
    if (cinema === "1"){
        rows = 20;
        columns = 12;
    }
    else if(cinema === "2"){
        rows = 25;
        columns = 16;
    }
    makeRows(rows);
    makeColumns(columns);
}

//Takes (rows, columns) input and makes a grid
function makeRows(rowNum) {

    //Creates rows
    for (let r = 0; r < rowNum; r++) {
        let row = document.createElement("div");
        container.appendChild(row).className = "row";
    }
}

//Creates columns
function makeColumns(cellNum) {
    for (let i = 0; i < rows.length; i++) {
        for (let j = 0; j < cellNum; j++) {
            let newCell = document.createElement("div");
            rows[i].appendChild(newCell).className = "seat";
        }

    }
}