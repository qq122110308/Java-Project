<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- 用于消息提示  模态框-->    
<!-- 模态框begin -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalTitle">${title }	</h4>
            </div>
            <div class="modal-body" id="modalContext">${message }</div>
            <div class="modal-footer">
                <a class="btn btn-default" data-dismiss="modal">关闭</a>
                <a  class="btn btn-primary" id="execute" >确认</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<div class="container">
    <h2 id="modalTopic"></h2>
    <div id="modal1" class="modal hide fade in" style="display: none; ">
        <div class="modal-header">
            <a class="close" data-dismiss="modal">×</a>
            <h3 id="modalTitle"></h3>
        </div>
        <div class="modal-body">
            <h4 id="modalTitle1">模态框中的文本</h4>
            <p id="modalContent">你可以在这添加一些文本。</p>
        </div>
        <div class="modal-footer">
            <a href="#" class="btn btn-success" id="execute" >确认</a>
            <a href="#" class="btn" data-dismiss="modal">关闭</a>
        </div>
    </div>
    <!-- 模态框按钮 -->
    <p style="display:none;"><a data-toggle="modal" href="#modal" class="btn btn-primary btn-large">发动演示模态框</a></p>
</div>
<!-- 模态框end -->