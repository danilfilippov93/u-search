var toggleAttributes = function () {
    var self = $(this);
    self.parents(".right-search-tool").find(".file-attributes").toggle(500);
    if(self.text() == "expand"){
        self.text("collapse");
    } else {
        self.text("expand");
    }
};

var setExpandEvents = function(){
    $(".expand-attributes").click(toggleAttributes);
}

function handleEvents(data) {
    var status = data.status;

    switch(status) {
        case "begin":
            break;

        case "complete":
            break;

        case "success":
            setExpandEvents();
            break;
    }
}