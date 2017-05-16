document.addEventListener('DOMContentLoaded', function() {

  String.prototype.firstLetterToUpper = function () {
    return this.charAt(0).toUpperCase() + this.slice(1);
  }

  const num = document.getElementById('numeroPkm');

  document.getElementById('btnPesquisar').onclick = () => {
  fetch(`http://pokeapi.co/api/v2/pokemon/${num.value}/`).then(response => response.json())
    .then(json => render(json));
  }

  function render(json) {
      console.log(json);
      const div = document.getElementById('detalhesPokemon');

      let img = document.createElement('img');
      let nameId = document.createElement('h2');
      let h3Types = document.createElement('h3');
      let h3Stats = document.createElement('h3');
      let types = document.createElement('ul');
      let stats = document.createElement('ul');
      let li;
      let progress;

      img.src = json.sprites.front_default;
      nameId.innerHTML = `${json.name.firstLetterToUpper()} - ${json.id}`;
      h3Types.innerHTML= 'Types';
      json.types.forEach(item => {
        li = document.createElement('li');      
        li.innerHTML = item.type.name;
        types.append(li);
      });
      h3Stats.innerHTML = 'Stats';
      json.stats.forEach(item => {
        progress = document.createElement('progress');
        progress.max = 100;
        progress.value = item.base_stat;

        li = document.createElement('li');      
        li.innerHTML = `${item.stat.name.firstLetterToUpper()} - `;
        li.appendChild(progress);
        stats.append(li);
      });


      div.append(nameId);
      div.append(img);
      div.append(h3Types);
      div.append(types);
      div.append(h3Stats);
      div.append(stats);
      div.append(document.createElement('hr'));
  }

});