<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<script src="${contextPath}/static/assets/js/ajaxfileupload.js" type="text/javascript"></script>
<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery.gritter.css" />
<div class="row">
	<div class="col-xs-12">
		<div class="well well-sm">
			<shiro:hasPermission name="ROLE_ADMIN:add">
				<a id="addInformationButton" role="button" class="btn btn-info btn-sm" data-toggle="modal">
					添加记录
				</a>
			</shiro:hasPermission>
			<shiro:lacksPermission name="ROLE_ADMIN:add">
				<a id="addInformationButton" disabled="disabled" role="button" class="btn btn-info btn-sm" data-toggle="modal">
					添加记录
				</a>
			</shiro:lacksPermission>
			<shiro:hasPermission name="ROLE_ADMIN:edit">
				<a id="editInformationButton" role="button" class="btn btn-purple btn-sm" data-toggle="modal">
					编辑记录
				</a>
			</shiro:hasPermission>
			<shiro:lacksPermission name="ROLE_ADMIN:edit">
				<a id="editInformationButton" role="button" disabled="disabled" class="btn btn-purple btn-sm" data-toggle="modal">
					编辑记录
				</a>
			</shiro:lacksPermission>

		</div>

		<table id="grid-table" class="bbs"></table>

		<div id="grid-pager"></div>

		<script type="text/javascript">
			var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
		</script>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<div id="modal-table" class="modal fade" tabindex="-1" data-backdrop="static">
	<div class="modal-dialog" style="min-width: 820px;">
		<form id="informationForm">
			<div class="modal-content">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						Banner信息管理
					</div>
				</div>
				<div class="modal-body" style="max-height: 500px;overflow-y: scroll;">
					<div id="modal-tip" class="red clearfix"></div>
					<div>
						<input type="hidden" id="id" name="id" />
						<input type="hidden" id="oper" name="oper"/>
					</div>
					<div class="blue clearfix" id="tipInfo" style="display: none">
						<table >
							<tbody>

							<tr id="FormError" style="display: table-row;" >
								<td class="ui-state-error" width="800"><span id="errorInfo"></span></td></tr></tbody></table>
					</div>
					<div class="blue clearfix">
						<table width="100%">
							<tr style="height:40px; list-style-type: none;">
								<td width="300" align="right">
									<label style="font-family: 'Courier New'">Banner 名称:</label>
								</td>
								<td width="500" align="left">
									<div class="col-sm-6 col-xs-12">
										<div class="input-icon block col-xs-12 no-padding">
											<i class="ace-icon fa fa-comments"></i>
											<input type="text" class="col-xs-12" name="bannerName" id="bannerName"  placeholder="请输入讨论组名称" />

										</div>
									</div>

								</td>
							</tr>
						</table>
					</div>

					<div style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden"></div>
					<div class="blue clearfix">
						<table width="100%">
							<tr style="height:40px; list-style-type: none;">
								<td width="300" align="right">
									<label style="font-family: 'Courier New'">Banner 排序:</label>
								</td>
								<td width="500" align="left">
									<div class="col-sm-6 col-xs-12">
										<div class="input-icon block col-xs-12 no-padding">
											<i class="ace-icon fa fa-flask"></i>
											<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" class="col-xs-12" name="bannerSort"  id="bannerSort"  placeholder="请输入排序值必须为数字" />

										</div>
									</div></td>
							</tr>
						</table>
					</div>
					<div style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden"></div>
					<div class="blue clearfix">
						<table width="100%">
							<tr style="height:40px; list-style-type: none;">
								<td width="300" align="right">
									<label style="font-family: 'Courier New'">Banner 图片:</label>
								</td>
								<td width="500" align="left">
									<div class="col-sm-6">
										<input type="file" class="col-xs-12" name="defaultIconUpload" id="defaultIconUpload"  placeholder="" onchange="return ajaxUpload('defaultIconUpload','defaultIconImg','defaultIcon');"/>
										<input type="text" readonly style="display: none" maxlength="20" class="col-xs-12" id="bannerUrl" name="bannerUrl" />
									</div>

									<span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="More details." title="请选择图片类型">?</span>
									<button type="button" id="btnInfo" class="btn btn-white btn-purple btn-sm" style="display: none" onclick="showBtnImg();">重传</button>

									<span id="imgInfo"></span>
								</td>
							</tr>
						</table>
					</div>
					<div style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden"></div>
					<div class="blue clearfix">
						<table width="100%">
							<tr style="height:60px; list-style-type: none;">
								<td width="300" align="right">
									<label style="font-family: 'Courier New'">Banner 备注:</label>
								</td>
								<td width="500" align="left">
									<div class="col-sm-6 col-xs-12">
										<div class="input-icon block col-xs-12 no-padding">
											<textarea class="form-control limited" id="bannerMemo" name="bannerMemo" maxlength="100" placeholder=""></textarea>

										</div>
									</div></td>
							</tr>
						</table>
					</div>
					<br/>
					<div style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden"></div>
					<div style="display: none;line-height: 10px" id="imgShow" align="center" >
					<img width="450" height="150"  src="" id="defaultIconImg"/>
					</div>
					<br/>
					<div class="modal-footer no-margin-top">
						<div class="text-center">
							<input id="submitButton" type="button" class="btn btn-app btn-success btn-xs"  value="保存"/>
							<input class="btn btn-app btn-pink btn-xs" data-dismiss="modal" value="取消"/>
						</div>
					</div>
				</div><!-- /.modal-content -->
			</div>
		</form>
	</div><!-- /.modal-dialog -->
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
	var scripts = [ null, "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", "${contextPath}/static/assets/js/jquery-ui.custom.js",
		"${contextPath}/static/assets/js/jquery.ui.touch-punch.js", "${contextPath}/static/assets/js/markdown/markdown.js", "${contextPath}/static/assets/js/markdown/bootstrap-markdown.js",
		"${contextPath}/static/assets/js/jquery.hotkeys.js", "${contextPath}/static/assets/js/bootstrap-wysiwyg.js", "${contextPath}/static/assets/js/bootbox.js", "${contextPath}/static/assets/js/jquery.gritter.js", null ]
	$(".page-content-area").ace_ajax("loadScripts", scripts, function() {
		// inline scripts related to this page
		jQuery(function($) {
			var grid_selector = "#grid-table";
			var pager_selector = "#grid-pager";

			// resize to fit page size
			$(window).on("resize.jqGrid", function() {
				$(grid_selector).jqGrid("setGridWidth", $(".page-content").width());
			})
			// resize on sidebar collapse/expand
			var parent_column = $(grid_selector).closest("[class*='col-']");
			$(document).on("settings.ace.jqGrid", function(ev, event_name, collapsed) {
				if (event_name === "sidebar_collapsed" || event_name === "main_container_fixed") {
					// setTimeout is for webkit only to give time for DOM changes and then redraw!!!
					setTimeout(function() {
						$(grid_selector).jqGrid("setGridWidth", parent_column.width());
					}, 0);
				}
			})


			jQuery(grid_selector).jqGrid({
				subGrid : false,
				url : "${contextPath}/sys/banner/getBanner",
				datatype : "json",
				height : 450,
				colNames : ['操作', 'ID', 'Banner 名称', 'Banner URL', 'Banner 排序'],
				colModel : [ {
					name : '',
					index : '',
					width : 80,
					fixed : true,
					sortable : false,
					resize : false,
					formatter : 'actions',
					formatoptions : {
						keys : true,
						editbutton : false,//disable delete button
						//delbutton : false,//disable delete button
						delOptions : {
							recreateForm : true,
							beforeShowForm : beforeDeleteCallback
						}
						//editformbutton:true, editOptions:{recreateForm:true, beforeShowForm:beforeEditCallback}
					}
				}, {
					name : 'id',
					index : 'id',
					label : 'ID',
					width : 60,
					sorttype : "long",
					search : false
				}, {
					name : 'bannerName',
					index : 'bannerName',
					label : 'Banner 名称',
					width : 120,
					editable : true,
					editoptions : {size : "20", maxlength : "20"},
					searchoptions : {sopt : ['like']},
					editrules : {required : true}
				}, {
					name : 'bannerUrl',
					index : 'bannerUrl',
					label : 'Banner URL',
					width : 160,
					editable : true,
					editoptions : {size : "20", maxlength : "40"},
//        				searchoptions : {sopt : ['cn']},
					search:false,
					editrules : {required : true}
				}, {
					name : 'bannerSort',
					index : 'bannerSort',
					label : 'Banner 排序',
					width : 100,
					editable : true,
					sorttype : "long",
					search : false,
					editrules : {number : true}
				} ],
				//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
				sortname : "id",
				sortorder : "asc",
				viewrecords : true,
				rowNum : 10,
				rowList : [ 10, 20, 30 ],
				pager : pager_selector,
				altRows : true,
				//toppager : true,
				multiselect : true,
				//multikey : "ctrlKey",
				multiboxonly : true,
				loadComplete : function() {
					var table = this;
					setTimeout(function(){
						styleCheckbox(table);
						updateActionIcons(table);
						updatePagerIcons(table);
						enableTooltips(table);
					}, 0);
				},
				editurl : "${contextPath}/sys/banner/operateBanner"
				//caption : "用户管理列表",
				//autowidth : true,
				/**
				 grouping : true,
				 groupingView : {
        				 groupField : ['name'],
        				 groupDataSorted : true,
        				 plusicon : 'fa fa-chevron-down bigger-110',
        				 minusicon : 'fa fa-chevron-up bigger-110'
        			},
				 */
			});

			$(window).triggerHandler("resize.jqGrid");// trigger window resize to make the grid get the correct size

			// enable search/filter toolbar
			// jQuery(grid_selector).jqGrid("filterToolbar",{defaultSearch:true,stringResult:true})
			// jQuery(grid_selector).filterToolbar({});
			// switch element when editing inline
			function aceSwitch(cellvalue, options, cell) {
				setTimeout(function() {
					$(cell).find("input[type=checkbox]").addClass("ace ace-switch ace-switch-5").after("<span class='lbl'></span>");
				}, 0);
			}



			$("#editor").ace_wysiwyg({
				toolbar:
						[
							"font",
							null,
							"fontSize",
							null,
							{name:"bold", className:"btn-info"},
							{name:"italic", className:"btn-info"},
							{name:"strikethrough", className:"btn-info"},
							{name:"underline", className:"btn-info"},
							null,
							{name:"insertunorderedlist", className:"btn-success"},
							{name:"insertorderedlist", className:"btn-success"},
							{name:"outdent", className:"btn-purple"},
							{name:"indent", className:"btn-purple"},
							null,
							{name:"justifyleft", className:"btn-primary"},
							{name:"justifycenter", className:"btn-primary"},
							{name:"justifyright", className:"btn-primary"},
							{name:"justifyfull", className:"btn-inverse"},
							null,
							{name:"createLink", className:"btn-pink"},
							{name:"unlink", className:"btn-pink"},
							null,
							{name:"insertImage", className:"btn-success"},
							null,
							"foreColor",
							null,
							{name:"undo", className:"btn-grey"},
							{name:"redo", className:"btn-grey"}
						],
				"wysiwyg": {
					fileUploadError: showErrorAlert
				}
			}).prev().addClass("wysiwyg-style3");

			function showErrorAlert(reason, detail) {
				var msg = "";
				if (reason === "unsupported-file-type") {
					msg = "Unsupported format " + detail;
				} else {
					// console.log("error uploading file", reason, detail);
				}
				$("<div class='alert'> <button type='button' class='close' data-dismiss='alert'>&times;</button>" + "<strong>File upload error</strong> " + msg + " </div>").prependTo("#alerts");
			}

			$("#addInformationButton").bind("click", function() {
				$("#modal-table").modal("toggle");
				$("#informationForm")[0].reset();
				$("#editor").html("");
				$("#modal-tip").html("");
				jQuery("#id").val("");
				jQuery("#imgShow").css("display","none");
				jQuery("#defaultIconUpload").show();
				jQuery("#bannerUrl").hide();
				jQuery("#btnInfo").hide();
				jQuery("#oper").val("add");
			});

			$("#editInformationButton").bind("click", function() {
				var selectedId = $(grid_selector).jqGrid("getGridParam", "selrow");
				jQuery("#oper").val("edit");
				if(null == selectedId){
					$.gritter.add({
						title: "系统信息",
						text: "请选择记录",
						class_name: "gritter-info gritter-center"
					});
				}else{
					$("#modal-table").modal("toggle");
					$("#id").val(jQuery(grid_selector).jqGrid("getRowData",jQuery(grid_selector).jqGrid("getGridParam", "selrow")).id);
					$("#bannerName").val(jQuery(grid_selector).jqGrid("getRowData",jQuery(grid_selector).jqGrid("getGridParam", "selrow")).bannerName);
					$("#bannerSort").val(jQuery(grid_selector).jqGrid("getRowData",jQuery(grid_selector).jqGrid("getGridParam", "selrow")).bannerSort);
					$("#bannerMemo").val(jQuery(grid_selector).jqGrid("getRowData",jQuery(grid_selector).jqGrid("getGridParam", "selrow")).bannerMemo);
					var typeInfo = jQuery(grid_selector).jqGrid("getRowData",jQuery(grid_selector).jqGrid("getGridParam", "selrow")).dictValue;


					var imageInfo = jQuery(grid_selector).jqGrid("getRowData",jQuery(grid_selector).jqGrid("getGridParam", "selrow")).bannerUrl;

					jQuery("#bannerUrl").show();
					jQuery("#bannerUrl").val(imageInfo);
					jQuery("#defaultIconUpload").hide();
					jQuery("#btnInfo").show();
					jQuery("#defaultIconImg").attr("src",imageInfo);
					jQuery("#imgShow").css("display","block");
				}
			});



			jQuery(".bbs tr td").click(function() {
				alert("aa");
			});

			jQuery("#submitButton").click(function(){
				var message = '';
				var bannerName = jQuery("#bannerName").val();
				var bannerUrl = jQuery("#bannerUrl").val();
				if(bannerName ==''){
					message+='提示：BANNER名称不能为空';
				}
				if(bannerUrl ==''){
					message+='提示：BANNER URL不能为空';
				}
				if(message != ''){
					jQuery('#tipInfo').show();
					jQuery('#errorInfo').html(message);
					return false;
				}else{
					jQuery('#tipInfo').hide();
				}
				jQuery.ajax({
					dataType : "json",
					url : "${contextPath}/sys/banner/operateBanner?oper=add",
					type : "post",
					data : {
						id : $("#id").val(),
						bannerName : $("#bannerName").val(),
						bannerSort : $("#bannerSort").val(),
						bannerUrl : $("#bannerUrl").val(),
						bannerMemo : $("#bannerMemo").val()
					},
					complete : function(xmlRequest) {
						$("#modal-table").modal("toggle");
						jQuery(grid_selector).trigger("reloadGrid");
					}
				});
			});


			// navButtons
			jQuery(grid_selector).jqGrid("navGrid", pager_selector, { // navbar options
				edit : false,
				editicon : "ace-icon fa fa-pencil blue",
				add : false,
				addicon : "ace-icon fa fa-plus-circle purple",
				del : true,
				delicon : "ace-icon fa fa-trash-o red",
				search : true,
				searchicon : "ace-icon fa fa-search orange",
				refresh : true,
				refreshicon : "ace-icon fa fa-refresh blue",
				view : true,
				viewicon : "ace-icon fa fa-search-plus grey"
			}, {
				// edit record form
				// closeAfterEdit: true,
				// width: 700,
				recreateForm : true,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest(".ui-jqdialog").find(".ui-jqdialog-titlebar").wrapInner("<div class='widget-header' />")
					style_edit_form(form);
				},
				errorTextFormat: function (response) {
					var result = eval("("+response.responseText+")");
					return result.message;
				}
			}, {
				// new record form
				// width: 700,
				closeAfterAdd : true,
				recreateForm : true,
				viewPagerButtons : false,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest(".ui-jqdialog").find(".ui-jqdialog-titlebar").wrapInner("<div class='widget-header' />")
					style_edit_form(form);
				},
				errorTextFormat: function (response) {
					var result = eval("("+response.responseText+")");
					return result.message;
				}
			}, {
				// delete record form
				recreateForm : true,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					if (form.data("styled"))
						return false;
					form.closest(".ui-jqdialog").find(".ui-jqdialog-titlebar").wrapInner("<div class='widget-header' />")
					style_delete_form(form);
					form.data("styled", true);
				},
				onClick : function(e) {
					// alert(1);
				}
			}, {
				// search form
				recreateForm : true,
				afterShowSearch : function(e) {
					var form = $(e[0]);
					form.closest(".ui-jqdialog").find(".ui-jqdialog-title").wrap("<div class='widget-header' />")
					style_search_form(form);
				},
				afterRedraw : function() {
					style_search_filters($(this));
				},
				multipleSearch : true
				/**
				 * multipleGroup:true, showQuery: true
				 */
			}, {
				// view record form
				recreateForm : true,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest(".ui-jqdialog").find(".ui-jqdialog-title").wrap("<div class='widget-header' />")
				}
			})

			// add custom button to export the data to excel
			jQuery(grid_selector).jqGrid("navButtonAdd", pager_selector,{
				caption : "",
				title : "导出Excel",
				buttonicon : "ace-icon fa fa-file-excel-o green",
				onClickButton : function () {
					var keys = [], ii = 0, rows = "";
					var ids = $(grid_selector).getDataIDs(); // Get All IDs
					var row = $(grid_selector).getRowData(ids[0]); // Get First row to get the labels
					//var label = $(grid_selector).jqGrid("getGridParam","colNames");
					for (var k in row) {
						keys[ii++] = k; // capture col names
						rows = rows + k + "\t"; // output each Column as tab delimited
					}
					rows = rows + "\n"; // Output header with end of line
					for (i = 0; i < ids.length; i++) {
						row = $(grid_selector).getRowData(ids[i]); // get each row
						for (j = 0; j < keys.length; j++)
							rows = rows + row[keys[j]] + "\t"; // output each Row as tab delimited
						rows = rows + "\n"; // output each row with end of line
					}
					rows = rows + "\n"; // end of line at the end
					var form = "<form name='csvexportform' action='${contextPath}/sys/information/operateInformation?oper=excel' method='post'>";
					form = form + "<input type='hidden' name='csvBuffer' value='" + encodeURIComponent(rows) + "'>";
					form = form + "</form><script>document.csvexportform.submit();</sc" + "ript>";
					OpenWindow = window.open("", "");
					OpenWindow.document.write(form);
					OpenWindow.document.close();
				}
			});

			function style_edit_form(form) {
				// form.find("input[name=statusCn]").addClass("ace ace-switch ace-switch-5").after("<span class="lbl"></span>");
				// don"t wrap inside a label element, the checkbox value won"t be submitted (POST"ed)
				// .addClass("ace ace-switch ace-switch-5").wrap("<label class="inline" />").after("<span class="lbl"></span>");

				// update buttons classes
				var buttons = form.next().find(".EditButton .fm-button");
				buttons.addClass("btn btn-sm").find("[class*='-icon']").hide();// ui-icon, s-icon
				buttons.eq(0).addClass("btn-primary").prepend("<i class='ace-icon fa fa-check'></i>");
				buttons.eq(1).prepend("<i class='ace-icon fa fa-times'></i>")

				buttons = form.next().find(".navButton a");
				buttons.find(".ui-icon").hide();
				buttons.eq(0).append("<i class='ace-icon fa fa-chevron-left'></i>");
				buttons.eq(1).append("<i class='ace-icon fa fa-chevron-right'></i>");
			}

			function style_delete_form(form) {
				var buttons = form.next().find(".EditButton .fm-button");
				buttons.addClass("btn btn-sm btn-white btn-round").find("[class*='-icon']").hide();// ui-icon, s-icon
				buttons.eq(0).addClass("btn-danger").prepend("<i class='ace-icon fa fa-trash-o'></i>");
				buttons.eq(1).addClass("btn-default").prepend("<i class='ace-icon fa fa-times'></i>")
			}

			function style_search_filters(form) {
				form.find(".delete-rule").val("X");
				form.find(".add-rule").addClass("btn btn-xs btn-primary");
				form.find(".add-group").addClass("btn btn-xs btn-success");
				form.find(".delete-group").addClass("btn btn-xs btn-danger");
			}

			function style_search_form(form) {
				var dialog = form.closest(".ui-jqdialog");
				var buttons = dialog.find(".EditTable");
				buttons.find(".EditButton a[id*='_reset']").addClass("btn btn-sm btn-info").find(".ui-icon").attr("class", "ace-icon fa fa-retweet");
				buttons.find(".EditButton a[id*='_query']").addClass("btn btn-sm btn-inverse").find(".ui-icon").attr("class", "ace-icon fa fa-comment-o");
				buttons.find(".EditButton a[id*='_search']").addClass("btn btn-sm btn-purple").find(".ui-icon").attr("class", "ace-icon fa fa-search");
			}

			function beforeDeleteCallback(e) {
				var form = $(e[0]);
				if (form.data("styled"))
					return false;
				form.closest(".ui-jqdialog").find(".ui-jqdialog-titlebar").wrapInner("<div class='widget-header' />")
				style_delete_form(form);
				form.data("styled", true);
			}

			function beforeEditCallback(e) {
				var form = $(e[0]);
				form.closest(".ui-jqdialog").find(".ui-jqdialog-titlebar").wrapInner("<div class='widget-header' />")
				style_edit_form(form);
			}

			// it causes some flicker when reloading or navigating grid
			// it may be possible to have some custom formatter to do this as the grid is being created to prevent this
			// or go back to default browser checkbox styles for the grid
			function styleCheckbox(table) {
				/**
				 * $(table).find("input:checkbox").addClass("ace") .wrap("<label />") .after("<span class="lbl align-top" />") $(".ui-jqgrid-labels th[id*="_cb"]:first-child")
				 * .find("input.cbox[type=checkbox]").addClass("ace") .wrap("<label />").after("<span class="lbl align-top" />");
				 */
			}

			// unlike navButtons icons, action icons in rows seem to be hard-coded
			// you can change them like this in here if you want
			function updateActionIcons(table) {
				/**
				 * var replacement = { "ui-ace-icon fa fa-pencil" : "ace-icon fa fa-pencil blue", "ui-ace-icon fa fa-trash-o" : "ace-icon fa fa-trash-o red", "ui-icon-disk" : "ace-icon fa fa-check green", "ui-icon-cancel" :
        			 * "ace-icon fa fa-times red" }; $(table).find(".ui-pg-div span.ui-icon").each(function(){ var icon = $(this); var $class = $.trim(icon.attr("class").replace("ui-icon", "")); if($class in replacement)
        			 * icon.attr("class", "ui-icon "+replacement[$class]); })
				 */
			}

			// replace icons with FontAwesome icons like above
			function updatePagerIcons(table) {
				var replacement = {
					"ui-icon-seek-first" : "ace-icon fa fa-angle-double-left bigger-140",
					"ui-icon-seek-prev" : "ace-icon fa fa-angle-left bigger-140",
					"ui-icon-seek-next" : "ace-icon fa fa-angle-right bigger-140",
					"ui-icon-seek-end" : "ace-icon fa fa-angle-double-right bigger-140"
				};
				$(".ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon").each(function() {
					var icon = $(this);
					var $class = $.trim(icon.attr("class").replace("ui-icon", ""));

					if ($class in replacement)
						icon.attr("class", "ui-icon " + replacement[$class]);
				})
			}

			function enableTooltips(table) {
				$(".navtable .ui-pg-button").tooltip({
					container : "body"
				});
				$(table).find(".ui-pg-div").tooltip({
					container : "body"
				});
			}

			// var selr = jQuery(grid_selector).jqGrid("getGridParam","selrow");

			$(document).one("ajaxloadstart.page", function(e) {
				$(grid_selector).jqGrid("GridUnload");
				$(".ui-jqdialog").remove();
			});

		});
	});

	function showBtnImg(){
		jQuery("#bannerUrl").hide();
		jQuery("#defaultIconUpload").show();
		jQuery("#imgShow").css("display","none");
		jQuery("#imgInfo").html("");
	}

	function ajaxUpload(id,imgId,hiddId){
		var content= jQuery("#"+id).val();
		if(content.length==''){
			alert("请选择图片!");
			return false;
		}
		jQuery.ajaxFileUpload
		(
				{
					url: "${contextPath}/sys/fileUpload/app?dir=BANNER", //你处理上传文件的服务端
					secureuri:false,
					fileElementId:id,
					dataType: 'json',
					success: function (data, status)
					{
						jQuery("#bannerUrl").val("${contextPath}/static/upload/"+data.file_path);
						jQuery("#imgInfo").html("图片上传成功");
						jQuery("#bannerUrl").show();
						jQuery("#defaultIconUpload").hide();
						jQuery("#btnInfo").show();
						jQuery("#defaultIconImg").attr("src","${contextPath}/static/upload/"+data.file_path);
						jQuery("#imgShow").show();

					},
					error: function (data, status, e)
					{
						jQuery("#imgInfo").html("图片上传失败");
					}
				}
		);
		return false;
	}

</script>
