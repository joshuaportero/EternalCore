package com.eternalcode.core.locale;

import com.eternalcode.core.configuration.contextual.ConfigItem;
import com.eternalcode.core.feature.language.Language;
import com.eternalcode.core.translation.AbstractTranslation;
import com.eternalcode.multification.bukkit.notice.BukkitNotice;
import com.eternalcode.multification.notice.Notice;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.dzikoysk.cdn.entity.Contextual;
import net.dzikoysk.cdn.entity.Description;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
@Accessors(fluent = true)
public class ENTranslation extends AbstractTranslation {

    ENTranslation(Language language) {
        super(language);
    }

    ENTranslation() {
        this(Language.EN);
    }

    @Description("# This section is responsible for all messages used during bad of a command argument")
    public ENArgumentSection argument = new ENArgumentSection();

    @Getter
    @Contextual
    public static class ENArgumentSection implements ArgumentSection {
        @Description("# {PERMISSIONS} - Required permission")
        public Notice permissionMessage = Notice.chat("<dark_red>✗ <red>You don't have permission to execute this command!");

        @Description({" ", "# {USAGE} - Correct usage"})
        public Notice usageMessage = Notice.chat("<red>Correct Usage: <white>{USAGE}");
        public Notice usageMessageHead = Notice.chat("<red>Correct Usage:");
        public Notice usageMessageEntry = Notice.chat("<red>► <white>{USAGE}");

        @Description(" ")
        public Notice offlinePlayer = Notice.chat("<dark_red>✗ <red>That player is currently offline!");
        public Notice onlyPlayer = Notice.chat("<dark_red>✗ <red>This command is only for players!");
        public Notice numberBiggerThanOrEqualZero = Notice.chat("<dark_red>✗ <red>The number must be greater than or equal to 0!");
        public Notice noItem = Notice.chat("<dark_red>✗ <red>You need item to use this command!");
        public Notice noMaterial = Notice.chat("<dark_red>✗ <red>This item doesn't exist");
        public Notice noArgument = Notice.chat("<dark_red>✗ <red>This argument doesn't exist");
        public Notice noDamaged = Notice.chat("<dark_red>✗ <red>This item can't be repaired");
        public Notice noDamagedItems = Notice.chat("<dark_red>✗ <red>You need damaged items to use this command!");
        public Notice noEnchantment = Notice.chat("<dark_red>✗ <red>This enchantment doesn't exist");
        public Notice noValidEnchantmentLevel = Notice.chat("<dark_red>✗ <red>This enchantment level is not supported!");
        public Notice invalidTimeFormat = Notice.chat("<dark_red>✗ <red>Invalid time format!");
        public Notice worldDoesntExist = Notice.chat("<dark_red>✗ <red>This world doesn't exist!");
        public Notice youMustGiveWorldName = Notice.chat("<dark_red>✗ <red>You must provide a world name!");
        public Notice incorrectLocation = Notice.chat("<dark_red>✗ <red>Incorrect location!");
        public Notice incorrectNumberOfChunks = Notice.chat("<dark_red>✗ <red>Incorrect number of chunks!");
    }

    @Description({
        " ",
        "# This answer is responsible for the general formatting of some values",
        "# The purpose of the section is to reduce the repetition of some messages."
    })
    public ENFormatSection format = new ENFormatSection();

    @Getter
    @Contextual
    public static class ENFormatSection implements Format {
        public String enable = "<green>enabled";
        public String disable = "<red>disabled";
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
        public Notice send = Notice.chat("<green>✔ <gray>The message has been successfully sent to an administrator");
        @Description("# {TIME} - Time to next use (cooldown)")
        public Notice helpOpDelay = Notice.chat("<dark_red>✗ <red>You need to wait <yellow>{TIME} <red>to use this command again");
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
        public Notice teleportedToPlayer = Notice.chat("<green>✔ <gray>You have been teleported to <yellow>{PLAYER}<gray>!");

        @Description({"# {PLAYER} - Teleported player, {ARG-PLAYER} - Player to whom another player has been transferred"})
        public Notice teleportedPlayerToPlayer = Notice.chat("<green>✔ <yellow>{PLAYER} <gray>has been teleported to <yellow>{ARG-PLAYER}<gray>!");

        @Description({"# {Y} - Y coordinate of the highest block"})
        public Notice teleportedToHighestBlock = Notice.chat("<green>✔ <gray>You have been teleported to the highest block! (Y: <yellow>{Y}<gray>)");

        // Task
        @Description({"# {TIME} - Teleportation time"})
        public Notice teleportTimerFormat = Notice.actionbar("<green>✔ <gray>You will be teleported in <yellow>{TIME}");
        @Description(" ")
        public Notice teleported = Notice.chat("<green>✔ <gray>You have been teleported!");
        public Notice teleporting = Notice.chat("<gold>🕛 <gray>Teleporting...");
        public Notice teleportTaskCanceled = Notice.chat("<dark_red>✗ <red>You've moved, teleportation canceled!");
        public Notice teleportTaskAlreadyExist = Notice.chat("<dark_red>✗ <red>You are already being teleported!");

        // Coordinates XYZ
        @Description({" ", "# {X} - X coordinate, {Y} - Y coordinate, {Z} - Z coordinate"})
        public Notice teleportedToCoordinates = Notice.chat("<green>✔ <gray>You have been teleported to location x: <yellow>{X}<gray>, y: <yellow>{Y}<gray>, z: <yellow>{Z}");
        @Description({" ", "# {PLAYER} -  Player who has been teleported, {X} - X coordinate, {Y} - Y coordinate, {Z} - Z coordinate"})
        public Notice teleportedSpecifiedPlayerToCoordinates = Notice.chat("<green>✔ <yellow>{PLAYER} <gray>has been teleported to location x: <yellow>{X}<gray>, y: <yellow>{Y}<gray>, z: <yellow>{Z}");

        // Back
        @Description(" ")
        public Notice teleportedToLastLocation = Notice.chat("<green>✔ <gray>You have been teleported to the last location!");
        @Description({" ", "# {PLAYER} - Player who has been teleported"})
        public Notice teleportedSpecifiedPlayerLastLocation = Notice.chat("<green>✔ <yellow>{PLAYER} <gray>has been teleported to the last location!");
        @Description(" ")
        public Notice lastLocationNoExist = Notice.chat("<dark_red>✗ <red>We can't find the last location to teleport to!");

        @Description(" ")
        public Notice randomPlayerNotFound = Notice.chat("<dark_red>✗ <red>We can't find the player to teleport to!");
        @Description({" ", "# {PLAYER} - The player you were teleported"})
        public Notice teleportedToRandomPlayer = Notice.chat("<dark_red>✗ <red>You have been teleported to a random player (<yellow>{PLAYER}<red>)!");
    }

    @Description({
        " ",
        "# This section is responsible for messages related to random teleport",
    })
    public ENRandomTeleportSection randomTeleport = new ENRandomTeleportSection();

    @Getter
    @Contextual
    public static class ENRandomTeleportSection implements RandomTeleportSection {
        public Notice randomTeleportStarted = Notice.chat("<green>✔ <gray>Teleportation to a random location has started!");
        public Notice randomTeleportFailed = Notice.chat("<dark_red>✗ <red>A safe location could not be found, please try again!");


        @Description({"# {PLAYER} - Player who has been teleported, {WORLD} - World name, {X} - X coordinate, {Y} - Y coordinate, {Z} - Z coordinate"})
        public Notice teleportedToRandomLocation = Notice.chat("<green>✔ <gray>You have been teleported to a random location!");

        @Description(" ")
        public Notice teleportedSpecifiedPlayerToRandomLocation = Notice.chat("<green>✔ <yellow>{PLAYER} <gray>has been teleported to a random location! His current location is: world: <yellow>{WORLD}<gray>, x: <yellow>{X}<gray>, y: <yellow>{Y}<gray>, z: <yellow>{Z}.");

        @Description({" ", "# {TIME} - Time to next use (cooldown)"})
        public Notice randomTeleportDelay = Notice.chat("<dark_red>✗ <red>You need to wait <yellow>{TIME} <red>to use this command again");

    }

    public ENChatSection chat = new ENChatSection();

    @Getter
    @Contextual
    public static class ENChatSection implements ChatSection {
        @Description({"# {PLAYER} - Player who performed the actions for the chat"})
        public Notice disabled = Notice.chat("<gold>🛈 <gray>Chat has been <red>disabled <gray>by <yellow>{PLAYER}<gray>!");
        public Notice enabled = Notice.chat("<gold>🛈 <gray>The chat has been <green>enabled <gray>by <yellow>{PLAYER}<gray>!");
        public Notice cleared = Notice.chat("<gold>🛈 <gray>Chat has been <cyan>cleared <gray>by <yellow>{PLAYER}<gray>!");

        @Description(" ")
        public Notice alreadyDisabled = Notice.chat("<dark_red>✗ <red>The chat is already disabled!");
        public Notice alreadyEnabled = Notice.chat("<dark_red>✗ <red>The chat is already enabled!");

        @Description({" ", "# {SLOWMODE} - Time for next message"})
        public Notice slowModeSet = Notice.chat("<gold>🛈 <gray>Players need to wait <yellow>{SLOWMODE} <gray>to send another message!");

        @Description({" ", "# {PLAYER} - Player who performed the actions for the chat"})
        public Notice slowModeOff = Notice.chat("<gold>🛈 <gray>Slow mode has been <red>disabled <gray>by <yellow>{PLAYER}<gray>!");

        @Description({" ", "# {TIME} - Time to next use (cooldown)"})
        public Notice slowMode = Notice.chat("<dark_red>✗ <red>You need to wait <yellow>{TIME} <red>to send another message!");

        @Description(" ")
        public Notice disabledChatInfo = Notice.chat("<dark_red>✗ <red>The chat is currently disabled!");

        @Description(" ")
        public Notice commandNotFound = Notice.chat("<dark_red>✗ <red>The command <red>{COMMAND} <dark_red>doesn't exists!");

        @Description({" ", "# {PLAYER} - Player who received the message", "# {MESSAGE} - message content", "# {TYPE} - message type"})
        public Notice tellrawInfo = Notice.chat("<gold>🛈 <gray>A message of type <yellow>{TYPE} <gray>was sent to <yellow>{PLAYER} <gray>with the content: {MESSAGE}");
        public Notice tellrawAllInfo = Notice.chat("<gold>🛈 <gray>A message of type <yellow>{TYPE} <gray>was sent to <yellow>all <gray>with the content: {MESSAGE}");

        public Notice tellrawSaved = Notice.chat("<gold>🛈 <gray>Message saved in queue!");
        public Notice tellrawNoSaved = Notice.chat("<dark_red>✗ <red>No messages saved in queue!");
        public Notice tellrawMultipleSent = Notice.chat("<gold>🛈 <gray>Messages sent! Message queue has been cleared!");
        public Notice tellrawCleared = Notice.chat("<gold>🛈 <gray>Message queue cleared!");
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
        public Notice tpaSelfMessage = Notice.chat("<dark_red>✗ <red>You can't teleport to yourself!");
        public Notice tpaAlreadySentMessage = Notice.chat("<dark_red>✗ <red>You have already sent a teleportation request!");
        public Notice tpaSentMessage = Notice.chat("<gold>🛈 <gray>You sent a request for teleportation to a player: <yellow>{PLAYER}<gray>!");

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
            .chat("     <gray>You have received a teleportation request from <yellow>{PLAYER}<gray>!")
            .chat("")
            .chat("                <green><hover:show_text:'<green>Accept the teleport request!</green>'><click:run_command:'/tpaccept {PLAYER}'>[ACCEPT]                          <red><hover:show_text:'<red>Decline the teleport request!</red>'><click:run_command:'/tpdeny {PLAYER}'>[DENY]")
            .chat("")
            .chat("               <underlined><green>                                               ")
            .chat("")
            .build();

        @Description(" ")
        public Notice tpaDenyNoRequestMessage = Notice.chat("<dark_red>✗ <red>You do not have a teleport request from this player!");

        @Description({" ", "# {PLAYER} - Player who sent a request to teleport to another player"})
        public Notice tpaDenyDoneMessage = Notice.chat("<dark_red>✗ <red>You declined the teleport request from <yellow>{PLAYER}<red>!");

        @Description({" ", "# {PLAYER} - Player who declines the tpa request"})
        public Notice tpaDenyReceivedMessage = Notice.chat("<dark_red>✗ <yellow>{PLAYER} <red>rejected your teleport request!");

        @Description(" ")
        public Notice tpaDenyAllDenied = Notice.chat("<dark_red>✗ <red>All players have declined your teleport request!");

        @Description({" ", "# {PLAYER} - Player who sent tpa request to another player"})
        public Notice tpaAcceptMessage = Notice.chat("<green>✔ <gray>You have accepted the teleportation from <yellow>{PLAYER}<green>!");

        @Description(" ")
        public Notice tpaAcceptNoRequestMessage = Notice.chat("<dark_red>✗ <red>This player has not sent you a teleport request!");

        @Description({" ", "# {PLAYER} - Player who sent a request to teleport to another player"})
        public Notice tpaAcceptReceivedMessage = Notice.chat("<green>✔ <yellow>{PLAYER} <green>accepted your teleportation request!");

        @Description(" ")
        public Notice tpaAcceptAllAccepted = Notice.chat("<green>✔ <gray>All players have accepted your teleport request!");
    }

    @Description({
        " ",
        "# This section is responsible for setting and editing private messages."
    })
    public ENPrivateSection privateChat = new ENPrivateSection();

    @Getter
    @Contextual
    public static class ENPrivateSection implements PrivateChatSection {
        public Notice noReply = Notice.chat("<dark_red>✗ <red>Looks like you're talking to yourself... again!");

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
        public Notice afkOn = Notice.chat("<gold>🛈 <yellow>{PLAYER} <gray>is currently <red>idle <gray>...");
        public Notice afkOff = Notice.chat("<gold>🛈 <yellow>{PLAYER} <gray>has <green>reconnected <gray>with the <green>world<gray>!");

        @Description({" ", "# {TIME} - Time after the player can execute the command."})
        public Notice afkDelay = Notice.chat("<dark_red>✗ <red>You need to wait <yellow>{TIME} <red>to use this command again");

        @Description({" "})
        public String afkKickReason = "<dark_red>✗ <red>You have been kicked due to inactivity!";
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
            Notice.chat("<white>☠ <dark_red>{PLAYER} <red>died!"),
            Notice.chat("<white>☠ <dark_red>{PLAYER} <red>was killed by <dark_red>{KILLER}!")
        );

        @Description({
            "# EternalCore will pick a random message for the list below, every time the player do a various action.",
            "# If the {KILLER} not be found, the message will be picked from list if contains cause.",
            "# List of DamageCauses: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/EntityDamageEvent.DamageCause.html"
        })
        public Map<EntityDamageEvent.DamageCause, List<Notice>> deathMessageByDamageCause = Map.of(
            EntityDamageEvent.DamageCause.VOID, Collections.singletonList(Notice.chat("<white>☠ <dark_red>{PLAYER} <red>fell into the void!")),
            EntityDamageEvent.DamageCause.FALL, Arrays.asList(
                Notice.chat("<white>☠ <dark_red>{PLAYER} <red>fell from a high place!"),
                Notice.chat("<white>☠ <dark_red>{PLAYER} <red>fell off a deadly cliff!")
            )
        );

        public List<Notice> unknownDeathCause = List.of(
            Notice.chat("<white>☠ <dark_red>{PLAYER} <red>died!")
        );

        @Description({"", "# {PLAYER} - Player who joined"})
        public List<Notice> joinMessage = List.of(
            Notice.actionbar("<gray>[<green>+<gray>] <yellow>{PLAYER} <gray>joined the server!")
        );

        @Description("# {PLAYER} - Player who left")
        public List<Notice> quitMessage = List.of(
            Notice.actionbar("<gray>[<red>-<gray>] <yellow>{PLAYER} <gray>left the server!")
        );

        // TITLE SECTION
        @Description({" ", "# {PLAYER} - Player who joined"})
        public Notice welcome = Notice.title("<gold><bold>DEVELOPMENT", "<yellow>This is a development server!");
    }

    @Description({" ", "# This section is responsible for spawn-related stuff."})
    public ENSpawnSection spawn = new ENSpawnSection();

    @Getter
    @Contextual
    public static class ENSpawnSection implements SpawnSection {
        public Notice spawnSet = Notice.chat("<green>✔ <gray>The server spawn point has been set!");
        public Notice spawnNoSet = Notice.chat("<dark_red>✗ <red>Whoops, looks like an admin forgot to set the spawn point!");
        @Description({" ", "# {PLAYER} - Player who teleported you to spawn"})
        public Notice spawnTeleportedBy = Notice.chat("<green>✔ <gray>You have been teleported to spawn by <yellow>{PLAYER}<gray>!");
        @Description({" ", "# {PLAYER} - Teleported player"})
        public Notice spawnTeleportedOther = Notice.chat("<green>✔ <gray>You have teleported <yellow>{PLAYER} <gray>to spawn!");
    }

    @Description({" ", "# Information sent, when the language is changed to English"})
    public ENLanguageSection language = new ENLanguageSection();

    @Getter
    @Contextual
    public static class ENLanguageSection implements LanguageSection {
        public Notice languageChanged = Notice.chat("<green>✔ <gray>Your language has been changed to <yellow>English<gray>!");

        public List<ConfigItem> decorationItems = List.of(
            ConfigItem.builder()
                .withMaterial(Material.SUNFLOWER)
                .withGlow(true)
                .withSlot(40)
                .withName("&7Our discord")
                .withLore(Collections.singletonList("&8» &6https://discord.gg/TRbDApaJaJ"))
                .build()
        );
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
                .actionBar("<green>✔ <gray>There are <yellow>%server_online% <gray>people online on the server!")
                .sound(Sound.ITEM_ARMOR_EQUIP_IRON, 1.0f, 1.0f)
                .build(),

            "2", BukkitNotice.builder()
                .chat("<white><bold>TIP<reset> <gray>You need help from an admin?")
                .chat("      <gray>Type command <white>/helpop <gray>to ask!")
                .chat("      <gray>You can just click here <dark_gray><click:suggest_command:'/helpop'>[CLICK HERE]")
                .sound(Sound.BLOCK_ANVIL_BREAK, 1.0f, 1.0f)
                .build()
        );

        public Notice enabled = Notice.chat("<green>✔ <gray>You have enabled auto messages!");
        public Notice disabled = Notice.chat("<dark_red>✗ <red>You have disabled auto messages!");

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
        public Notice jailLocationSet = Notice.chat("<green>✔ <gray>Jail location has been set!");
        public Notice jailLocationRemove = Notice.chat("<dark_red>✗ <red>Jail location has been removed!");
        public Notice jailLocationNotSet = Notice.chat("<dark_red>✗ <red>Jail location is not set!");
        public Notice jailLocationOverride = Notice.chat("<green>✔ <gray>Jail location has been overridden");

        @Description({" ", "# Section responsible for detaining players"})
        public Notice jailDetainPrivate = Notice.chat("<gold>🔒 <gray>You've been <red>caught <gray>and now you're paying the <red>price<gray>!");
        public Notice jailCannotUseCommand = Notice.chat("<dark_red>✗ <red>You can't use commands while you are in jail!");
        @Description({" ", "# {PLAYER} - Player who has been detained"})
        public Notice jailDetainOverride = Notice.chat("<gold>🛈 <gray>You have overridden the jail time for <yellow>{PLAYER}<gold>!");
        @Description({" ", "# {PLAYER} - Player who has been detained"})
        public Notice jailDetainBroadcast = Notice.chat("<gold>🔒 <gray><yellow>{PLAYER} <gray>has been <red>caught <gray>and now it's paying the <red>price<gray>!");
        @Description({" ", "# {REMAINING_TIME} - Time left to release"})
        public Notice jailDetainCountdown = Notice.actionbar("<gold>🔒 <gray>You are in jail! <gray>Time left: <yellow>{REMAINING_TIME}<gray>!");
        @Description({" ", "# {PLAYER} - Admin who you can't detain"})
        public Notice jailDetainAdmin = Notice.chat("<dark_red>✗ <red>You can't jail <yellow>{PLAYER} <red>because he is an admin!");

        @Description({" ", "# Section responsible for releasing players from jail"})
        @Description({" ", "# {PLAYER} - Player who has been released from jail"})
        public Notice jailReleaseBroadcast = Notice.chat("<gold>🔓 <gray><yellow>{PLAYER} <gray>has been <green>freed <gray>from their <red>cell<gray>!");
        public Notice jailReleasePrivate = Notice.actionbar("<gold>🔒 <gray>You have been released from <red>jail<gray>!");
        @Description({" ", "# {PLAYER} - Player nickname"})
        public Notice jailIsNotPrisoner = Notice.chat("<dark_red>✗ <red>The player <yellow>{PLAYER} <red>is not a prisoner!");

        @Description({" ", "# Section responsible for listing players in jail"})
        public Notice jailListHeader = Notice.chat("<gold>🔒 <gray>Players in jail: ");
        public Notice jailListEmpty = Notice.chat("<dark_red>✗ <red>There are no players in jail!");
        @Description({" ", "# {PLAYER} - Player who has been detained", "# {REMAINING_TIME} - Time of detention", "# {DETAINED_BY} - Player who detained the player"})
        public Notice jailListPlayerEntry = Notice.chat("<green>► <yellow>{PLAYER} <gray>(<yellow>{REMAINING_TIME}<gray>) <gray>detained by <red>{DETAINED_BY}<gray>!");
    }
}
