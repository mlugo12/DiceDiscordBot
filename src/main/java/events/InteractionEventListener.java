package events;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class InteractionEventListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        switch (event.getName()) {
            case "roll":
                OptionMapping option = event.getOption("dice");

                if (option == null) {
                    event.reply("Wrong Dice Input").queue();
                    return;
                }

                String dice = option.getAsString();

                String[] parts = dice.split("d");
                int min = Integer.parseInt(parts[0]);
                int max = Integer.parseInt(parts[1]);
                int range = (max * min);
                int rand = (int) (Math.random() * range + 1);

                event.reply("Result: " + rand).queue();

                if (rand == 1) {
                    event.reply("Aint no way :skull:").queue();
                } else if (rand == range) {
                    event.reply("Aint no way :skull:").queue();
                }
                break;
        }
    }
}

