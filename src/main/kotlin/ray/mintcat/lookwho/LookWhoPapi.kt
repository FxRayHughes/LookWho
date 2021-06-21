package ray.mintcat.lookwho

import io.izzel.taboolib.module.compat.PlaceholderHook
import io.izzel.taboolib.module.inject.THook
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

@THook
class LookWhoPapi: PlaceholderHook.Expansion {

    override fun plugin(): Plugin {
        return LookWho.plugin
    }

    override fun identifier(): String {
        return "look"
    }

    override fun onPlaceholderRequest(player: Player, params: String): String {
        val list = Bukkit.getOnlinePlayers().filter { player.hasLineOfSight(it) }
        if (list.isNotEmpty()){
            return list[0].name
        }
        return ""
    }
}