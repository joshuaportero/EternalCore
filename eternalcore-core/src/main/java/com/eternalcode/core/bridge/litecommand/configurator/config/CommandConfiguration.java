package com.eternalcode.core.bridge.litecommand.configurator.config;

import com.eternalcode.core.configuration.ReloadableConfig;
import com.eternalcode.core.injector.annotations.component.ConfigurationFile;
import net.dzikoysk.cdn.entity.Description;
import net.dzikoysk.cdn.source.Resource;
import net.dzikoysk.cdn.source.Source;

import java.io.File;
import java.util.List;
import java.util.Map;

@ConfigurationFile
public class CommandConfiguration implements ReloadableConfig {

    @Description({
        "# This file allows you to configure commands.",
        "# You can change command name, aliases and permissions.",
        "# You can edit the commands as follows this template:",
        "# commands:",
        "#   <command_name>:",
        "#     name: \"<new_command_name>\"",
        "#     aliases:",
        "#       - \"<new_command_aliases>\"",
        "#     permissions:",
        "#       - \"<new_command_permission>\"",
        "#     subCommands:",
        "#       <default_sub_command_name>:",
        "#         name: <new_sub_command_name>",
        "#         disabled: false/true",
        "#         aliases:",
        "#           - \"<new_sub_command_aliases>\"",
        "#         permissions:",
        "#           - \"<new_sub_command_permission>\"",
    })

    public Map<String, Command> commands = Map.of(
        "eternalcore", new Command(
            "eternal-core",
            List.of("eternal"),
            List.of("eternalcore.eternalcore"),
            Map.of("reload", new SubCommand("reload", true, List.of("rl"), List.of("eternalcore.reload"))),
            true)
    );

    @Override
    public Resource resource(File folder) {
        return Source.of(folder, "commands.yml");
    }

}
