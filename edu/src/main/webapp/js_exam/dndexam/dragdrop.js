var source, drop;
function initiate(){
  source=document.getElementById('image');
  source.addEventListener('dragstart', dragged, false); // 부모 객체의 캡처링을 차단해야 하는 듯.

  drop=document.getElementById('dropbox');
  drop.addEventListener('dragover', function(e){ e.preventDefault(); }, false); // 드래그 존에서 drop이 불가능한 기능을 차단.
  drop.addEventListener('drop', dropped, false);
}
function dragged(e){
  var code='<img src="'+source.getAttribute('src')+'">';
  e.dataTransfer.setData('Text', code); // 전달하려는 데이터를 dataTransfer 객체에 set으로 저장.
}
function dropped(e){
  e.preventDefault(); // 기본적으로 모든 태그에는 drop이 불가능하게 하는 기능이 있으므로 드롭 존에선 삭제해야 한다.
  drop.innerHTML=e.dataTransfer.getData('Text'); // e.dataTransfer에 저장한 데이터를 가져와서 interHTML에 삽입.
}
window.addEventListener('load', initiate, false); // 캡처링 차단.