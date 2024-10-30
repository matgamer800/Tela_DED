import Data.dao.PlayerWithHabilidade
import Data.dao.Raca_Dao
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tela.R
import com.example.tela.databinding.PlayerItemBinding


class PlayerAdapter(
    private val onEditClick: (PlayerWithHabilidade) -> Unit,
    private val onDeleteClick: (PlayerWithHabilidade) -> Unit,
    private val onRunClick: (PlayerWithHabilidade) -> Unit
) : ListAdapter<PlayerWithHabilidade, PlayerAdapter.PlayerViewHolder>(PlayerComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = PlayerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    inner class PlayerViewHolder(private val binding: PlayerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val str_forca = "Força :"
        val str_destr = "Destreza :"
        val str_cosnt = "Constituição :"
        val str_intel = "Inteligência :"
        val str_sabed = "Sabedoria :"
        val str_caris = "Carisma :"
        val spaceT = "\t\t"

        @SuppressLint("SetTextI18n")
        fun bind(playerWithHabilidade: PlayerWithHabilidade) {
            // Exibe o nome do player e detalhes de habilidades
            binding.playerName.text = playerWithHabilidade.player.nome_player
            binding.habilidadeDetails.text = (
                    str_forca + playerWithHabilidade.habilidade.forca.toString() + spaceT +
                            str_destr + playerWithHabilidade.habilidade.destreza.toString() + spaceT +
                            str_cosnt + playerWithHabilidade.habilidade.constituicao.toString() + spaceT +
                            str_intel + playerWithHabilidade.habilidade.inteligencia.toString() + spaceT +
                            str_sabed + playerWithHabilidade.habilidade.sabedoria.toString() + spaceT +
                            str_caris + playerWithHabilidade.habilidade.carisma.toString()
                    )
            binding.RacaName.text ="Raça :"+ playerWithHabilidade.raca.Nome_raca
            binding.ClasseName.text ="Classe :"+ playerWithHabilidade.classe.Nome_classe
            binding.QtdVida.text = "Vida :"+ playerWithHabilidade.player.vida.toString()
            val imageResource = getImageResource(playerWithHabilidade.raca.Nome_raca)
            binding.imageView2.setImageResource(imageResource)

            // Atribui ações aos botões
            binding.idEdit.setOnClickListener() {
                onEditClick(playerWithHabilidade)
            }
            binding.idDelete.setOnClickListener() {
                onDeleteClick(playerWithHabilidade)
            }
            binding.idStart.setOnClickListener() {
                onRunClick(playerWithHabilidade)
            }
        }
        fun getImageResource(characterType: String): Int {
            return when (characterType) {
                "Humano" -> R.drawable.humano
                else -> R.drawable.esboco
            }
        }
    }

    class PlayerComparator : DiffUtil.ItemCallback<PlayerWithHabilidade>() {
        override fun areItemsTheSame(oldItem: PlayerWithHabilidade, newItem: PlayerWithHabilidade): Boolean {
            return oldItem.player.id_player == newItem.player.id_player
        }

        override fun areContentsTheSame(oldItem: PlayerWithHabilidade, newItem: PlayerWithHabilidade): Boolean {
            return oldItem == newItem
        }
    }
}
