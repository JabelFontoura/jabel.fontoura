document.addEventListener('DOMContentLoaded', function() {

  const color = document.getElementById('colorPkm');

    document.getElementById('btnPesquisar').onclick = () => {
      Object.values(hexToRgb(color.value)).forEach(item => {
        fetch(`http://pokeapi.co/api/v2/pokemon/${item}`).then(response => response.json())
          .then(json => render(json));
      });
    }

  function render(json) {
    document.getElementsByTagName("body")[0].style.background = color.value;

    const div = document.getElementById('detalhesPokemon');
    const img = document.createElement('img');
    
    img.src = json.sprites.front_default;

    div.append(img);
  }

  function hexToRgb(hex) {
    var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
    return result ? {
        r: parseInt(result[1], 16),
        g: parseInt(result[2], 16),
        b: parseInt(result[3], 16)
    } : null;
  } 
});