package kono_fan.events.commands;

/**
 * <p>
 *     {@code ICommand} 介面是每一個斜線指令處理實體的通用介面，只有一個 {@link ICommand#commandProcess} 方法，令其可以使用
 *     Lambda建立實體。
 * </p>
 *
 * @author Alex Cai
 * @see UseCommand
 * @see UserInformation
 * @since 1.0
 */
public interface ICommand
{
	/**
	 * <p>
	 * 實際處理指令的方法。
	 * </p>
	 * @param event 斜線指令的事件，攜帶了指令資訊和使用者資訊
	 */
	void commandProcess(net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent event); //指令
}