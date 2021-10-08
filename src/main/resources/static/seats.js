const container = document.querySelector('.container');
let rows = document.getElementsByClassName("row");
let cinema = document.querySelector('.cinema').textContent;
let selectedseats = document.getElementById('selected-seats');
console.log(selectedseats.textContent);

//Seat click event
container.addEventListener('click', e => {
    if (e.target.classList.contains('seat') &&
        !e.target.classList.contains('occupied')) {

        if (e.target.classList.contains('selected')){
            //get child of selectedseats and remove it
            let deleteme = document.getElementById('s' + e.target.id);
            deleteme.remove();
        }
        else{
            //append child to selectedseats with seat id
            let seatinput = document.createElement('input');
            seatinput.setAttribute('name', 'seats');
            seatinput.setAttribute('id', 's' + e.target.id);
            seatinput.setAttribute('value', e.target.id);
            selectedseats.appendChild(seatinput);
        }
        e.target.classList.toggle('selected');

        console.log(e.target.id)
    }
});

function hasClass(element, className){
    element.classList.contains(className);
}

let idseats = list.map(a => a.idseats);

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
    let idCounter = 1;
    if(cinema === "2"){
        idCounter = 241;
    }

    for (let i = 0; i < rows.length; i++) {
        for (let j = 0; j < cellNum; j++) {

            let newCell = document.createElement("div");
            newCell.setAttribute('id', idCounter.toString());
            if (idseats.includes(idCounter)){
                rows[i].appendChild(newCell).className = "seat occupied";
            }
            else {
                rows[i].appendChild(newCell).className = "seat";
            }
            idCounter++;
        }
    }
}