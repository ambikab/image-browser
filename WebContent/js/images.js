/* create a modal pop up */
function showForm(){
	/* Modal properties on info button click*/
	$("#addNewImage").dialog({
		autoOpen: false,
		modal: true,
		title:'Add New Image',
		maxHeight: 600,
		minHeight: 200,
		resizable: false,
		draggable: false,
		width:650,
		buttons: {
			'Close': function () {
				$(this).dialog("close");
			}
		}
	});
	/*Render the modal*/
	$('#addNewImage').dialog('open');
}

function showImage(imageName) {
	$("#displayImage").html("<img src='ImageViewController?imgId=" + imageName +"' />");
	/* Modal properties on info button click*/
	$("#displayImage").dialog({
		autoOpen: false,
		modal: true,
		title: imageName,
		maxHeight: 600,
		minHeight: 200,
		resizable: false,
		draggable: false,
		width:650,
		buttons: {
			'Close': function () {
				$(this).dialog("close");
			}
		}
	});
	/*Render the modal*/
	$('#displayImage').dialog('open');
}