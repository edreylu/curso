
function mensaje() {

    alert('correcto!');
}

function mensaje2() {
  swal({
    title: 'Are you sure?',
    text: "You won't be able to revert this!",
    type: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes, delete it!'
  }).then(function() {
    swal(
      'Deleted!',
      'Your file has been deleted.',
      'success'
    )
  })
}

function mensaje3(){
  swal({
    title: 'Yeeeaaaah!!!',
    text: '',
    imageUrl: 'https://wasabiBD.github.io/test-repo/dia2/images/feito.png',
    imageWidth: 164,
    imageHeight: 205,
    padding: 10,
    animation: true,
  });
}

function nobackbutton(){
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button" //chrome
window.onhashchange=function(){window.location.hash="no-back-button";}
	
}


function LoadingSpinner (form, spinnerHTML) {
  form = form || document
  
  //Keep track of button & spinner, so there's only one automatic spinner per form
  var button
  var spinner = document.createElement('div')
  spinner.innerHTML = spinnerHTML
  spinner = spinner.firstChild

  //Delegate events to a root element, so you don't need to attach a spinner to each individual button.
  form.addEventListener('click', start)

  //Stop automatic spinner if validation prevents submitting the form
  //Invalid event doesn't bubble, so use capture
  form.addEventListener('invalid', stop, true)

  //Start spinning only when you click a submit button
  function start (event) {
    if (button) stop()
    button = event.target
    if (button.type === 'submit') {
      LoadingSpinner.start(button, spinner)
    }
  }

  function stop () {
    LoadingSpinner.stop(button, spinner)
  }

  function destroy () {
    stop()
    form.removeEventListener('click', start)
    form.removeEventListener('invalid', stop, true)
  }

  return {start: start, stop: stop, destroy: destroy}
}

//I guess these would be called class methods. They're useable without instantianing a new LoadingSpinner so you can start & stop spinners manually on any elements, for ajax and stuff.
LoadingSpinner.start = function (element, spinner) {
  element.classList.add('loading')
  return element.appendChild(spinner)
}

LoadingSpinner.stop = function (element, spinner) {
  element.classList.remove('loading')
  return spinner.remove()
}
        
var loginForm = document.querySelector('#loginForm')
var loginLoader = new LoadingSpinner(loginForm, 'Cargando...')
//Delay submit so you can see the spinner spinning, then stop the loading spinner instead of submitting because we're on Codepen.
loginForm.addEventListener('submit', function (event) {
  event.preventDefault()
  setTimeout(function () {
    loginLoader.stop()
  }, 2000)
})

// capcha
function enabledSubmit() {
 var botonSubmit = document.getElementById("submit");
 botonSubmit.disabled = false;
}

function miFuncion(a) {
    var response = grecaptcha.getResponse();

    if(response.length == 0){
        alert("Captcha no verificado, favor de verificar");
        return false;
      event.preventDefault();
    } else {
        
      return true;
    }
  }