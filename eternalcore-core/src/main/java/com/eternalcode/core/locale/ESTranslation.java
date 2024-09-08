package com.eternalcode.core.locale;

import com.eternalcode.core.feature.language.Language;
import com.eternalcode.core.translation.AbstractTranslation;
import com.eternalcode.multification.bukkit.notice.BukkitNotice;
import com.eternalcode.multification.notice.Notice;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.dzikoysk.cdn.entity.Contextual;
import net.dzikoysk.cdn.entity.Description;
import org.bukkit.Sound;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.*;

@Getter
@Accessors(fluent = true)
public class ESTranslation extends AbstractTranslation {

    ESTranslation(Language language) {
        super(language);
    }

    ESTranslation() {
        this(Language.ES);
    }

    @Description("# This section is responsible for all messages used during bad of a command argument")
    public ENArgumentSection argument = new ENArgumentSection();

    @Getter
    @Contextual
    public static class ENArgumentSection implements ArgumentSection {
        @Description("# {PERMISSIONS} - Required permission")
        public Notice permissionMessage = Notice.chat("<dark_red>✗ <red>No tienes permiso para ejecutar este comando!");

        @Description({" ", "# {USAGE} - Correct usage"})
        public Notice usageMessage = Notice.chat("<red>Uso correcto: <white>{USAGE}");
        public Notice usageMessageHead = Notice.chat("<red>Uso correcto:");
        public Notice usageMessageEntry = Notice.chat("<red>► <white>{USAGE}");

        @Description(" ")
        public Notice offlinePlayer = Notice.chat("<dark_red>✗ <red>Ese jugador está desconectado o no existe!");
        public Notice onlyPlayer = Notice.chat("<dark_red>✗ <red>Este comando solo puede ser usado por jugadores!");
        public Notice numberBiggerThanOrEqualZero = Notice.chat("<dark_red>✗ <red>El numero debe ser mayor o igual a 0!");
        public Notice noItem = Notice.chat("<dark_red>✗ <red>Necesitas un objeto para usar este comando!");
        public Notice noMaterial = Notice.chat("<dark_red>✗ <red>Este objeto no existe!");
        public Notice noArgument = Notice.chat("<dark_red>✗ <red>Este argumento no existe!");
        public Notice noDamaged = Notice.chat("<dark_red>✗ <red>Este objeto no puede ser reparado!");
        public Notice noDamagedItems = Notice.chat("<dark_red>✗ <red>Necesitas objetos dañados para usar este comando!");
        public Notice noEnchantment = Notice.chat("<dark_red>✗ <red>Este encantamiento no existe!");
        public Notice noValidEnchantmentLevel = Notice.chat("<dark_red>✗ <red>El nivel de este encantamiento no es válido o no es soportado!");
        public Notice invalidTimeFormat = Notice.chat("<dark_red>✗ <red>Formato de tiempo no válido!");
        public Notice worldDoesntExist = Notice.chat("<dark_red>✗ <red>El mundo proporcionado no existe!");
        public Notice youMustGiveWorldName = Notice.chat("<dark_red>✗ <red>Debes proporcionar un nombre de mundo!");
        public Notice incorrectLocation = Notice.chat("<dark_red>✗ <red>La ubicación es incorrecta!");
        public Notice incorrectNumberOfChunks = Notice.chat("<dark_red>✗ <red>Número incorrecto de chunks!");
    }

    @Description({
        " ",
        "# This section is responsible for the player support chat /helpop",
    })
    public ENHelpOpSection helpOp = new ENHelpOpSection();

    @Getter
    @Contextual
    public static class ENHelpOpSection implements HelpOpSection {
        @Description("# {PLAYER} - Player who send message on /helpop, {TEXT} - message")
        public Notice format = Notice.chat("<dark_gray>[<red>HelpOp<dark_gray>] <yellow>{PLAYER}<dark_gray>: <white>{TEXT}");
        @Description(" ")
        public Notice send = Notice.chat("<green>✔ <gray>El mensaje ha sido enviado a un administrador!");
        @Description("# {TIME} - Time to next use (cooldown)")
        public Notice helpOpDelay = Notice.chat("<dark_red>✗ <red>Necesitas esperar <yellow>{TIME} <red>para usar este comando otra vez!");
    }

    @Description({
        " ",
        "# This section is responsible for messages related to teleportation",
    })
    public ENTeleportSection teleport = new ENTeleportSection();

    @Getter
    @Contextual
    public static class ENTeleportSection implements TeleportSection {
        // teleport
        @Description({"# {PLAYER} - Teleported players"})
        public Notice teleportedToPlayer = Notice.chat("<green>✔ <gray>Has sido teletransportado a <yellow>{PLAYER}<gray>!");

        @Description({"# {PLAYER} - Teleported player, {ARG-PLAYER} - Player to whom another player has been transferred"})
        public Notice teleportedPlayerToPlayer = Notice.chat("<green>✔ <yellow>{PLAYER} <gray>fue teletransportado a <yellow>{ARG-PLAYER}<gray>!");

        @Description({"# {Y} - Y coordinate of the highest block"})
        public Notice teleportedToHighestBlock = Notice.chat("<green>✔ <gray>Has sido teletransportado al bloque más alto! (Y: <yellow>{Y}<gray>)");

        // Task
        @Description({"# {TIME} - Teleportation time"})
        public Notice teleportTimerFormat = Notice.actionbar("<green>✔ <gray>Vas a ser teletransportado en <yellow>{TIME}<gray>!");
        @Description(" ")
        public Notice teleported = Notice.chat("<green>✔ <gray>Has sido teletransportado!");
        public Notice teleporting = Notice.chat("<gold>🕛 <gray>Teletransportando...");
        public Notice teleportTaskCanceled = Notice.chat("<dark_red>✗ <red>Te has movido, teletransportación cancelada!");
        public Notice teleportTaskAlreadyExist = Notice.chat("<dark_red>✗ <red>Ya estás siendo teletransportado!");

        // Coordinates XYZ
        @Description({" ", "# {X} - X coordinate, {Y} - Y coordinate, {Z} - Z coordinate"})
        public Notice teleportedToCoordinates = Notice.chat("<green>✔ <gray>Has sido teletransportado a la ubicación x: <yellow>{X}<gray>, y: <yellow>{Y}<gray>, z: <yellow>{Z}");
        @Description({" ", "# {PLAYER} -  Player who has been teleported, {X} - X coordinate, {Y} - Y coordinate, {Z} - Z coordinate"})
        public Notice teleportedSpecifiedPlayerToCoordinates = Notice.chat("<green>✔ <yellow>{PLAYER} <gray>ha sido teletransportado a la ubicación x: <yellow>{X}<gray>, y: <yellow>{Y}<gray>, z: <yellow>{Z}");

        // Back
        @Description(" ")
        public Notice teleportedToLastLocation = Notice.chat("<green>✔ <gray>You have been teleported to the last location!");
        @Description({" ", "# {PLAYER} - Player who has been teleported"})
        public Notice teleportedSpecifiedPlayerLastLocation = Notice.chat("<green>✔ <yellow>{PLAYER} <gray>ha sido teletransportado a la última ubicación!");
        @Description(" ")
        public Notice lastLocationNoExist = Notice.chat("<dark_red>✗ <red>No podemos encontrar tu última ubicación!");

        @Description(" ")
        public Notice randomPlayerNotFound = Notice.chat("<dark_red>✗ <red>No logramos encontrar a un jugador al azar!");
        @Description({" ", "# {PLAYER} - The player you were teleported"})
        public Notice teleportedToRandomPlayer = Notice.chat("<green>✔ <gray>Has sido teletransportado a un jugador al azar (<yellow>{PLAYER}<gray>)!");
    }

    public ENChatSection chat = new ENChatSection();

    @Getter
    @Contextual
    public static class ENChatSection implements ChatSection {
        @Description({"# {PLAYER} - Player who performed the actions for the chat"})
        public Notice disabled = Notice.chat("<gold>🛈 <gray>El chat ha sido <red>deshabilitado <gray>por <yellow>{PLAYER}<gray>!");
        public Notice enabled = Notice.chat("<gold>🛈 <gray>El chat ha sido <green>habilitado <gray>por <yellow>{PLAYER}<gray>!");
        public Notice cleared = Notice.chat("<gold>🛈 <gray>El chat ha sido <cyan>limpiado <gray>por <yellow>{PLAYER}<gray>!");

        @Description(" ")
        public Notice alreadyEnabled = Notice.chat("<dark_red>✗ <red>El chat ya está habilitado!");
        public Notice alreadyDisabled = Notice.chat("<dark_red>✗ <red>El chat ya está deshabilitado!");

        @Description({" ", "# {SLOWMODE} - Time for next message"})
        public Notice slowModeSet = Notice.chat("<gold>🛈 <gray>Los jugadores necesitan esperar <yellow>{SLOWMODE} <gray>para enviar otro mensaje!");

        @Description({" ", "# {PLAYER} - Player who performed the actions for the chat"})
        public Notice slowModeOff = Notice.chat("<gold>🛈 <gray>El modo lento ha sido <red>deshabilitado <gray>por <yellow>{PLAYER}<gray>!");

        @Description({" ", "# {TIME} - Time to next use (cooldown)"})
        public Notice slowMode = Notice.chat("<dark_red>✗ <red>Necesitas esperar <yellow>{TIME} <red>para enviar otro mensaje!");

        @Description(" ")
        public Notice disabledChatInfo = Notice.chat("<dark_red>✗ <red>El chat está actualmente deshabilitado!");

        @Description(" ")
        public Notice commandNotFound = Notice.chat("<dark_red>✗ <red>El comando <red>{COMMAND} <dark_red>no existe!");

        @Description({" ", "# {PLAYER} - Player who received the message", "# {MESSAGE} - message content", "# {TYPE} - message type"})
        public Notice tellrawInfo = Notice.chat("<gold>🛈 <gray>Se ha enviado un mensaje de tipo <yellow>{TYPE} <gray>a <yellow>{PLAYER} <gray>con el contenido: {MESSAGE}");
        public Notice tellrawAllInfo = Notice.chat("<gold>🛈 <gray>Se ha enviado un mensaje de tipo <yellow>{TYPE} <gray>a <yellow>todos <gray>con el contenido: {MESSAGE}");

        public Notice tellrawSaved = Notice.chat("<gold>🛈 <gray>Mensaje guardado en cola!");
        public Notice tellrawNoSaved = Notice.chat("<dark_red>✗ <red>No hay mensajes guardados en cola!");
        public Notice tellrawMultipleSent = Notice.chat("<gold>🛈 <gray>Mensajes enviados! La cola de mensajes ha sido limpiada!");
        public Notice tellrawCleared = Notice.chat("<gold>🛈 <gray>Cola de mensajes limpiada!");
    }

    @Description({
        " ",
        "# This section is responsible for handling tpa requests,",
        "# It gives you the ability to edit queries of this type",
    })
    public ENTpaSection tpa = new ENTpaSection();

    @Getter
    @Contextual
    public static class ENTpaSection implements TpaSection {
        public Notice tpaSelfMessage = Notice.chat("<dark_red>✗ <red>No puedes teletransportarte a ti mismo!");
        public Notice tpaAlreadySentMessage = Notice.chat("<dark_red>✗ <red>Ya has enviado una petición de teletransportación!");
        public Notice tpaSentMessage = Notice.chat("<gold>🛈 <gray>Has enviado una petición de teletransportación a un jugador: <yellow>{PLAYER}<gray>!");

        @Description({
            " ",
            "# We used MiniMessages formatting in these messages",
            "# The current request acceptance message allows the player to click on it to accept the teleport request with MiniMessages!",
            "# More information about MiniMessages: https://docs.adventure.kyori.net/minimessage/format.html",
        })
        @Description({" ", "# {PLAYER} - Player who sent the request to another player"})
        public Notice tpaReceivedMessage = Notice.builder()
            .chat("               <underlined><green>                                               ")
            .chat("")
            .chat("   <gray>Has recibido una petición de teletransportación de <yellow>{PLAYER}<gray>!")
            .chat("")
            .chat("                <green><hover:show_text:'<green>Aceptar la petición de teletransportación!</green>'><click:run_command:'/tpaccept {PLAYER}'>[ACEPTAR]                      <red><hover:show_text:'<red>Denegar la petición de teletransportación!</red>'><click:run_command:'/tpdeny {PLAYER}'>[DENEGAR]")
            .chat("")
            .chat("               <underlined><green>                                               ")
            .chat("")
            .build();

        @Description(" ")
        public Notice tpaDenyNoRequestMessage = Notice.chat("<dark_red>✗ <red>No tienes una petición de teletransportación de este jugador!");

        @Description({" ", "# {PLAYER} - Player who sent a request to teleport to another player"})
        public Notice tpaDenyDoneMessage = Notice.chat("<dark_red>✗ <red>Rechazaste la petición de teletransportación de <yellow>{PLAYER}<red>!");

        @Description({" ", "# {PLAYER} - Player who declines the tpa request"})
        public Notice tpaDenyReceivedMessage = Notice.chat("<dark_red>✗ <yellow>{PLAYER} <red>rechazó tu petición de teletransportación!");

        @Description(" ")
        public Notice tpaDenyAllDenied = Notice.chat("<dark_red>✗ <red>Todos los jugadores han rechazado tu petición de teletransportación!");

        @Description({" ", "# {PLAYER} - Player who sent tpa request to another player"})
        public Notice tpaAcceptMessage = Notice.chat("<green>✔ <gray>Has aceptado la teletransportación de <yellow>{PLAYER}<green>!");

        @Description(" ")
        public Notice tpaAcceptNoRequestMessage = Notice.chat("<dark_red>✗ <red>Este jugador no ha enviado una petición de teletransportación!");

        @Description({" ", "# {PLAYER} - Player who sent a request to teleport to another player"})
        public Notice tpaAcceptReceivedMessage = Notice.chat("<green>✔ <yellow>{PLAYER} <green>aceptó tu petición de teletransportación!");

        @Description(" ")
        public Notice tpaAcceptAllAccepted = Notice.chat("<green>✔ <gray>Todos los jugadores han aceptado tu petición de teletransportación!");
    }

    @Description({
        " ",
        "# This section is responsible for setting and editing private messages."
    })
    public ENPrivateSection privateChat = new ENPrivateSection();

    @Getter
    @Contextual
    public static class ENPrivateSection implements PrivateChatSection {
        public Notice noReply = Notice.chat("<dark_red>✗ <red>Parece que estás hablando contigo... de nuevo!");

        @Description("# {TARGET} - Player that you want to send messages, {MESSAGE} - Message")
        public Notice privateMessageYouToTarget = Notice.chat("<dark_gray>[<gray>You -> <yellow>{TARGET}<dark_gray>]<white>: {MESSAGE}");

        @Description({" ", "# {SENDER} - Message sender, {MESSAGE} - Message"})
        public Notice privateMessageTargetToYou = Notice.chat("<dark_gray>[<gray>{SENDER} -> <yellow>You<dark_gray>]<white>: {MESSAGE}");
    }

    @Description({
        " ",
        "# Section responsible for AFK."
    })
    public ENAfkSection afk = new ENAfkSection();

    @Getter
    @Contextual
    public static class ENAfkSection implements AfkSection {
        @Description("# {PLAYER} - Player who is in AFK")
        public Notice afkOn = Notice.chat("<gold>🛈 <yellow>{PLAYER} <gray>está actualmente <red>inactivo <gray>...");
        public Notice afkOff = Notice.chat("<gold>🛈 <yellow>{PLAYER} <gray>ha <green>reconectado <gray>con el mundo <green>!</gray>");

        @Description({" ", "# {TIME} - Time after the player can execute the command."})
        public Notice afkDelay = Notice.chat("<dark_red>✗ <red>Necesitas esperar <yellow>{TIME} <red>para usar este comando otra vez");

        @Description({" "})
        public String afkKickReason = "<dark_red>✗ <red>Has sido expulsado debido a la inactividad!";
    }

    @Description({
        " ",
        "# Section responsible for various server events."
    })
    public ENEventSection event = new ENEventSection();

    @Getter
    @Contextual
    public static class ENEventSection implements EventSection {
        @Description("# {PLAYER} - Killed player, {KILLER} - Killer")
        public List<Notice> deathMessage = List.of(
            Notice.chat("<white>☠ <dark_red>{PLAYER} <red>murió!"),
            Notice.chat("<white>☠ <dark_red>{PLAYER} <red>fue asesinado por <dark_red>{KILLER}!")
        );

        @Description({
            "# EternalCore will pick a random message for the list below, every time the player do a various action.",
            "# If the {KILLER} not be found, the message will be picked from list if contains cause.",
            "# List of DamageCauses: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/EntityDamageEvent.DamageCause.html"
        })
        public Map<EntityDamageEvent.DamageCause, List<Notice>> deathMessageByDamageCause = Map.of(
            EntityDamageEvent.DamageCause.VOID, Collections.singletonList(Notice.chat("<white>☠ <dark_red>{PLAYER} <red>cayó en el vacío!")),
            EntityDamageEvent.DamageCause.FALL, Arrays.asList(
                Notice.chat("<white>☠ <dark_red>{PLAYER} <red>cayó de un lugar alto!"),
                Notice.chat("<white>☠ <dark_red>{PLAYER} <red>cayó de una caña mortal!")
            )
        );

        public List<Notice> unknownDeathCause = List.of(
            Notice.chat("<white>☠ <dark_red>{PLAYER} <red>murió!")
        );

        @Description({"", "# {PLAYER} - Player who joined"})
        public List<Notice> joinMessage = List.of(
            Notice.actionbar("<gray>[<green>+<gray>] <yellow>{PLAYER} <gray>entró al servidor!")
        );

        @Description("# {PLAYER} - Player who left")
        public List<Notice> quitMessage = List.of(
            Notice.actionbar("<gray>[<red>-<gray>] <yellow>{PLAYER} <gray>salió del servidor!")
        );

        // TITLE SECTION
        @Description({" ", "# {PLAYER} - Player who joined"})
        public Notice welcome = Notice.title("<gold><bold>DESARROLLO", "<yellow>Este es un servidor de desarrollo!");
    }

    @Description({" ", "# This section is responsible for spawn-related stuff."})
    public ENSpawnSection spawn = new ENSpawnSection();

    @Getter
    @Contextual
    public static class ENSpawnSection implements SpawnSection {
        public Notice spawnSet = Notice.chat("<green>✔ <gray>El punto de aparición del servidor ha sido establecido!");
        public Notice spawnNoSet = Notice.chat("<dark_red>✗ <red>Ups, parece que un administrador olvidó establecer el punto de aparición del servidor!");
        @Description({" ", "# {PLAYER} - Player who teleported you to spawn"})
        public Notice spawnTeleportedBy = Notice.chat("<green>✔ <gray>Has sido teletransportado a la aparición del servidor por <yellow>{PLAYER}<gray>!");
        @Description({" ", "# {PLAYER} - Teleported player"})
        public Notice spawnTeleportedOther = Notice.chat("<green>✔ <gray>Has sido teletransportado a la aparición del servidor <yellow>{PLAYER} <gray>!");
    }

    @Description({" ", "# Auto message"})
    public ENAutoMessageSection autoMessage = new ENAutoMessageSection();

    @Getter
    @Contextual
    public static class ENAutoMessageSection implements AutoMessageSection {

        @Description({
            "",
            "# If you want to useplaceholder %server_online% you need to install",
            "# PlaceholderAPI plugin and download placeholders for Server",
            "# like /papi ecloud download Server",
        })
        public Map<String, Notice> messages = Map.of(
            "1", BukkitNotice.builder()
                .actionBar("<green>✔ <gray>Hay <yellow>%server_online% <gray>personas en línea en el servidor!")
                .sound(Sound.ITEM_ARMOR_EQUIP_IRON, 1.0f, 1.0f)
                .build(),

            "2", BukkitNotice.builder()
                .chat("<white><bold>TIP <reset><gray>Necesitas ayuda de un administrador?")
                .chat("      <gray>Escribe el comando <white>/helpop <gray>para pedirlo!")
                .chat("      <gray>Puedes simplemente hacer clic aquí <dark_gray><click:suggest_command:'/helpop'>[CLIC AQUÍ]")
                .sound(Sound.BLOCK_ANVIL_BREAK, 1.0f, 1.0f)
                .build()
        );

        public Notice enabled = Notice.chat("<green>✔ <gray>Has <green>habilitado <gray>los mensajes automáticos!");
        public Notice disabled = Notice.chat("<dark_red>✗ <gray>Has <red>deshabilitado <gray>los mensajes automáticos!");

        @Override
        public Collection<Notice> messages() {
            return this.messages.values();
        }

        @Override
        public Notice enabled() {
            return this.enabled;
        }

        @Override
        public Notice disabled() {
            return this.disabled;
        }
    }


    @Description({" ", "# This section is responsible for handling jail-related stuff."})
    public ENJailSection jailSection = new ENJailSection();

    @Getter
    @Contextual
    public static class ENJailSection implements JailSection {
        @Description({" ", "# Section responsible for location of jail setup"})
        public Notice jailLocationSet = Notice.chat("<green>✔ <gray>El lugar de la cárcel ha sido establecido!");
        public Notice jailLocationRemove = Notice.chat("<dark_red>✗ <red>El lugar de la cárcel ha sido eliminado!");
        public Notice jailLocationNotSet = Notice.chat("<dark_red>✗ <red>El lugar de la cárcel no está establecido!");
        public Notice jailLocationOverride = Notice.chat("<green>✔ <gray>El lugar de la cárcel ha sido anulado");

        @Description({" ", "# Section responsible for detaining players"})
        public Notice jailDetainPrivate = Notice.chat("<gold>🔒 <gray>Has sido <red>capturado <gray>y ahora estás pagando el <red>precio<gray>!");
        public Notice jailCannotUseCommand = Notice.chat("<dark_red>✗ <red>No puedes usar comandos mientras estás en la cárcel!");
        @Description({" ", "# {PLAYER} - Player who has been detained"})
        public Notice jailDetainOverride = Notice.chat("<gold>🛈 <gray>Has <green>anulado <gray>el tiempo de la cárcel para <yellow>{PLAYER}<gold>!");
        @Description({" ", "# {PLAYER} - Player who has been detained"})
        public Notice jailDetainBroadcast = Notice.chat("<gold>🔒 <gray><yellow>{PLAYER} <gray>ha sido <red>capturado <gray>y ahora está pagando el <red>precio<gray>!");
        @Description({" ", "# {REMAINING_TIME} - Time left to release"})
        public Notice jailDetainCountdown = Notice.actionbar("<gold>🔒 <gray>Estás en la cárcel! <gray>Tiempo restante: <yellow>{REMAINING_TIME}<gray>!");
        @Description({" ", "# {PLAYER} - Admin who you can't detain"})
        public Notice jailDetainAdmin = Notice.chat("<dark_red>✗ <red>No puedes encarcelar a <yellow>{PLAYER} <red>porque es un administrador!");

        @Description({" ", "# Section responsible for releasing players from jail"})
        @Description({" ", "# {PLAYER} - Player who has been released from jail"})
        public Notice jailReleaseBroadcast = Notice.chat("<gold>🔓 <gray><yellow>{PLAYER} <gray>ha sido <green>liberado <gray>de su <red>cárcel<gray>!");
        public Notice jailReleasePrivate = Notice.actionbar("<gold>🔒 <gray>Has sido <green>liberado <gray>de la cárcel!");
        @Description({" ", "# {PLAYER} - Player nickname"})
        public Notice jailIsNotPrisoner = Notice.chat("<dark_red>✗ <red>El jugador <yellow>{PLAYER} <red>no es un preso!");

        @Description({" ", "# Section responsible for listing players in jail"})
        public Notice jailListHeader = Notice.chat("<gold>🔒 <gray>Jugadores en la cárcel: ");
        public Notice jailListEmpty = Notice.chat("<dark_red>✗ <red>No hay jugadores en la cárcel!");
        @Description({" ", "# {PLAYER} - Player who has been detained", "# {REMAINING_TIME} - Time of detention", "# {DETAINED_BY} - Player who detained the player"})
        public Notice jailListPlayerEntry = Notice.chat("<green>► <yellow>{PLAYER} <gray>(<yellow>{REMAINING_TIME}<gray>) <gray>detenido por <red>{DETAINED_BY}<gray>!");
    }
}
