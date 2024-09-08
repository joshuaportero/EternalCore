package com.eternalcode.core.translation;

import com.eternalcode.core.feature.language.Language;
import com.eternalcode.multification.notice.Notice;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Translation {

    Language getLanguage();

    // argument section
    ArgumentSection argument();

    interface ArgumentSection {
        Notice permissionMessage();

        Notice usageMessage();

        Notice usageMessageHead();

        Notice usageMessageEntry();

        Notice offlinePlayer();

        Notice onlyPlayer();

        Notice numberBiggerThanOrEqualZero();

        Notice noArgument();

        Notice noEnchantment();

        Notice invalidTimeFormat();
    }

    // HelpOp Section
    HelpOpSection helpOp();

    interface HelpOpSection {
        Notice format();

        Notice send();

        Notice helpOpDelay();
    }

    // Teleport Section
    TeleportSection teleport();

    interface TeleportSection {
        // teleport
        Notice teleportedToPlayer();

        Notice teleportedPlayerToPlayer();

        Notice teleportedToHighestBlock();

        // Task
        Notice teleportTimerFormat();

        Notice teleported();

        Notice teleporting();

        Notice teleportTaskCanceled();

        Notice teleportTaskAlreadyExist();

        // Coordinates XYZ
        Notice teleportedToCoordinates();

        Notice teleportedSpecifiedPlayerToCoordinates();

        // Back
        Notice teleportedToLastLocation();

        Notice teleportedSpecifiedPlayerLastLocation();

        Notice lastLocationNoExist();

        // teleport to random player command
        Notice randomPlayerNotFound();

        Notice teleportedToRandomPlayer();
    }

    // Chat Section
    ChatSection chat();

    interface ChatSection {
        Notice disabled();

        Notice enabled();

        Notice cleared();

        Notice alreadyDisabled();

        Notice alreadyEnabled();

        Notice slowModeSet();

        Notice slowModeOff();

        Notice slowMode();

        Notice disabledChatInfo();

        Notice commandNotFound();
    }

    // tpa section
    TpaSection tpa();

    interface TpaSection {
        Notice tpaSelfMessage();

        Notice tpaAlreadySentMessage();

        Notice tpaSentMessage();

        Notice tpaReceivedMessage();

        Notice tpaDenyNoRequestMessage();

        Notice tpaDenyDoneMessage();

        Notice tpaDenyReceivedMessage();

        Notice tpaDenyAllDenied();

        Notice tpaAcceptMessage();

        Notice tpaAcceptNoRequestMessage();

        Notice tpaAcceptReceivedMessage();

        Notice tpaAcceptAllAccepted();
    }

    // private section
    PrivateChatSection privateChat();

    interface PrivateChatSection {
        Notice noReply();

        Notice privateMessageYouToTarget();

        Notice privateMessageTargetToYou();
    }

    // afk section
    AfkSection afk();

    interface AfkSection {
        Notice afkOn();

        Notice afkOff();

        Notice afkDelay();

        String afkKickReason();
    }

    // event section
    EventSection event();

    interface EventSection {
        List<Notice> deathMessage();

        List<Notice> unknownDeathCause();

        List<Notice> joinMessage();

        List<Notice> quitMessage();

        Map<EntityDamageEvent.DamageCause, List<Notice>> deathMessageByDamageCause();

        Notice welcome();
    }

    // spawn section
    SpawnSection spawn();

    interface SpawnSection {
        // spawn
        Notice spawnSet();

        Notice spawnNoSet();

        Notice spawnTeleportedBy();

        Notice spawnTeleportedOther();
    }

    AutoMessageSection autoMessage();

    interface AutoMessageSection {
        Collection<Notice> messages();

        Notice enabled();

        Notice disabled();
    }

    JailSection jailSection();

    interface JailSection {
        Notice jailLocationSet();

        Notice jailLocationRemove();

        Notice jailLocationNotSet();

        Notice jailLocationOverride();

        Notice jailDetainBroadcast();

        Notice jailDetainPrivate();

        Notice jailDetainCountdown();

        Notice jailDetainOverride();

        Notice jailDetainAdmin();

        Notice jailReleaseBroadcast();

        Notice jailReleasePrivate();

        Notice jailIsNotPrisoner();

        Notice jailListHeader();

        Notice jailListEmpty();

        Notice jailListPlayerEntry();

        Notice jailCannotUseCommand();
    }

}
