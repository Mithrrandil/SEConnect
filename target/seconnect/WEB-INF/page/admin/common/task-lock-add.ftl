<div class="modal fade bs-example-modal-lg" id="btn-insert-single-lock-modal" tabindex="-1" role="dialog"
     data-backdrop=false data-keyboard=false>
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">
                    <i class="fa fa-rocket" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;柜级锁体数据增加请求
                </h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal">
                    <div class="form-group">
                        <div class="alert alert-danger" role="alert">
                            注意：柜级锁体数据请求只能在 <strong>一周</strong> 之内提交一次<br/>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请求提交后将第一时间通知至超级管理员处,请耐心等待<br/>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请求通过后,锁体增加的材料将通过快递的形式交您的手中,请保持电话通畅<br/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="realName" class="layui-col-sm2 control-label">请求的锁柜数目</label>
                        <div class="layui-col-sm10">
                            <input type="text" class="form-control" name="lockNumber" placeholder="锁柜数目">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btn-insert-single-lock">提交</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>