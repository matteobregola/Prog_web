function setColor(){
    let choice = document.getElementById("colorForm").color.selectedIndex;
    let colorCode;
    switch(choice){
        case 0: colorCode = "#FF0000"; break; // red
        case 1: colorCode = "#00FF00"; break; // green
        case 2: colorCode = "#0000FF"; break; // blue
        case 3: colorCode = "#FFFFFF"; break; // white
        case 4: colorCode = "#FFFF00"; break; // yellow
        case 5: colorCode = "#FF00FF"; break; // purple
    }
    document.body.style.backgroundColor = colorCode ;
};
