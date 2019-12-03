<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>User Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <!-- Bulma Version 0.8.x-->
    <link rel="stylesheet" href="/node_modules/bulma/css/bulma.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin.css">
</head>

<body>

<!-- START NAV -->
<jsp:include page="../../../resources/static/header.html"/>
<!-- END NAV -->
<div class="container">
    <div class="columns">
        <div class="column is-3 ">
            <!-- START MENU-->
            <jsp:include page="../../../resources/static/menu.html"/>
            <!-- END MENU-->
        </div>
        <div id="editForm" class="column is-9 is-hidden">
            <div class="field">
                <label class="label">Name</label>
                <div class="control">
                    <input id="inputName" class="input" type="text" placeholder="Last First">
                </div>
            </div>

            <div class="field">
                <label class="label">Height (Feet)</label>
                <div class="control">
                    <input id="inputHeight" class="input" type="text" placeholder="1 Feet = 12 Inches">
                </div>
                <p id="helpHeight" class="help is-danger is-hidden">Height must be a number</p>
            </div>

            <div class="field">
                <label class="label">Target Weight (pounds)</label>
                <div class="control">
                    <input id="inputWeight" class="input" type="text" placeholder="e.g. 160">
                </div>
                <p id="helpWeight" class="help is-danger is-hidden">Target weight must be a number</p>
            </div>

            <div class="field">
                <label class="label">Gender</label>
                <div class="control">
                    <div class="select">
                        <select id="inputGender">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Others">Others</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="field">
                <label class="label">Motto</label>
                <div class="control">
                    <textarea id="inputMotto" class="textarea" placeholder="Keep fighting..."></textarea>
                </div>
            </div>

            <div class="field is-grouped">
                <div class="control">
                    <button id="buttonSubmit" class="button is-link">Submit</button>
                </div>
                <div class="control">
                    <button id="buttonCancel" class="button is-warning">Cancel</button>
                </div>
            </div>
        </div>
        <div id="viewForm" class="column is-9">
            <div class="field">
                <label class="label">Name</label>
                <div class="control">
                    <span id="valueName" class="is-subtitle"></span>
                </div>
            </div>

            <div class="field">
                <label class="label">Height (Feet)</label>
                <div class="control">
                    <span id="valueHeight" class="is-subtitle"></span>
                </div>
            </div>

            <div class="field">
                <label class="label">Target Weight (pounds)</label>
                <div class="control">
                    <span id="valueWeight" class="is-subtitle"></span>
                </div>
            </div>

            <div class="field">
                <label class="label">Gender</label>
                <div class="control">
                    <span id="valueGender" class="is-subtitle"></span>
                </div>
            </div>

            <div class="field">
                <label class="label">Motto</label>
                <div class="control">
                    <span id="valueMotto" class="is-subtitle"></span>
                </div>
            </div>

            <div class="field is-grouped">
                <div class="control">
                    <button id="buttonEdit" class="button is-link">Edit</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script async type="text/javascript" src="/js/bulma.js"></script>
<script type="text/javascript" src="/js/register.js"></script>
<script type="text/javascript" src="/js/user.js"></script>
<script type="text/javascript" src="/node_modules/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="/node_modules/axios/dist/axios.js"></script>
</body>
<script>
    $(function(){
        $('.profile').addClass("is-active");
        $('#buttonEdit').on('click',function(){
            $('#viewForm').addClass('is-hidden');
            $('#editForm').removeClass('is-hidden');
        })
        $('#buttonCancel').on('click',function(){
            $('#viewForm').removeClass('is-hidden');
            $('#editForm').addClass('is-hidden');
        })
        $('#buttonSubmit').on('click',function(){
            let name = $('#inputName').val();
            let height = $('#inputHeight').val();
            if(isNaN(height)){
                $('#helpHeight').removeClass("is-hidden");
                $('#inputHeight').addClass("is-danger");
                return;
            }
            let target_weight = $('#inputWeight').val();
            if(isNaN(target_weight)){
                $('#helpWeight').removeClass("is-hidden");
                $('#inputWeight').addClass("is-danger");
                return;
            }
            let gender = $('#inputGender').val();
            let motto = $('#inputMotto').val();
            updateInfo(name,height,target_weight,gender,motto).then(res=>{
                if(res.data) location.href="";
                else alert("Error");
            }).catch(err=>{
                console.log(err);
            })
        })
        getInfo().then(res=>{
            let user = res.data;
            $('#inputName').val(user.name);
            $('#inputHeight').val(user.height);
            $('#inputWeight').val(user.target_weight);
            $('#inputGender').val(user.gender);
            $('#inputMotto').val(user.motto);

            $('#valueName').html(user.name);
            $('#valueHeight').html(user.height);
            $('#valueWeight').html(user.target_weight);
            $('#valueGender').html(user.gender);
            $('#valueMotto').html(user.motto);
            console.log(res);
        }).catch(err=>{
            console.log(err);
        })
    })
</script>
</html>