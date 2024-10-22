import Data.dao.PlayerWithHabilidade
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tela.databinding.PlayerItemBinding


class PlayerAdapter : ListAdapter<PlayerWithHabilidade, PlayerAdapter.PlayerViewHolder>(PlayerComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = PlayerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class PlayerViewHolder(private val binding: PlayerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(playerWithHabilidade: PlayerWithHabilidade) {
            binding.playerName.text = playerWithHabilidade.player.nome_player
            binding.habilidadeDetails.text = playerWithHabilidade.habilidade.toString()
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
