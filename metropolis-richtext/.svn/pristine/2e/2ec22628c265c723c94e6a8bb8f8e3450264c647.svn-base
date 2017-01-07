$("#uploadfile").uploadFile({
	url : base + "/upload.htm",
	acceptFiles : "image/*",
	showPreview : true,
	previewHeight : "100px",
	previewWidth : "100px",
	maxFileSize : 1024 * 1024 * 5,
	showDelete : true,
	showDownload : true,
	returnType : 'json',
	downloadCallback : true,
	formData : {
		"isRename" : true,
	},
	downloadCallback : function(filename, pd) {
		location.href = base + "/download.htm?filePath=" + filename[0];
	}
});
